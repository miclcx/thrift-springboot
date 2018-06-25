package com.intellif.jianyi.service.impl;

import com.intellif.jianyi.dao.SolrConfigDao;
import com.intellif.jianyi.service.ShareSolrDataService;
import com.intellif.jianyi.vo.SolrConfigInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class ShareSolrDataServiceImpl implements ShareSolrDataService {

    protected final Logger LOG = LogManager.getLogger(this.getClass());
    private static Map<String, HttpSolrClient> urlServerMap = new HashMap<String, HttpSolrClient>();
    private static List<HttpSolrClient> allServer = new ArrayList<HttpSolrClient>();
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2, 200, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(Integer.MAX_VALUE), new ThreadPoolExecutor.CallerRunsPolicy());

    public static final String DEFAULT_FL = "id,type,camera,file,time,score,gender,race,accessories,version,quality,age";

    @Autowired
    SolrConfigDao solrConfigRepository;
    @Value("${solr.search.timeout}")
    private int solrSearchTimeout;
    @Value("${solr.connet.timeout}")
    private int solrConnectTimeout;
    @Value("${solr.result.maxsize}")
    private int solrResultMaxsize;

    public synchronized List<HttpSolrClient> getAllServer() throws MalformedURLException {
        if (allServer.size() == 0) {
            Iterable<SolrConfigInfo> solrConfigList = solrConfigRepository.findAll();
            Set<String> urlSet = new HashSet<String>();
            for (SolrConfigInfo solrConfigInfo : solrConfigList) {
                urlSet.add(solrConfigInfo.getServerUrl());
            }
            for (String url : urlSet) {
                if (!urlServerMap.containsKey(url)) {
                    HttpSolrClient server = new HttpSolrClient(url);
                    server.setSoTimeout(solrSearchTimeout);
                    server.setConnectionTimeout(solrConnectTimeout);
                    server.setDefaultMaxConnectionsPerHost(100);
                    server.setMaxTotalConnections(100);
                    // defaults to false
                    server.setFollowRedirects(false);
                    // allowCompression defaults to false.
                    // Server side must support gzip or deflate for this to have
                    // any effect.
                    server.setAllowCompression(true);
                    urlServerMap.put(url, server);
                }
                allServer.add(urlServerMap.get(url));
            }
        }
        return allServer;
    }

	
	public String getFileName(String filePath) {
		int length = filePath.split("/").length;
		String fileName = filePath.split("/")[length - 1];
		return fileName;
	}

    @Override
    public long faceSearchCountAll(long startTime, long endTime, String faceFeature, double threshold) throws Exception {
        return faceSearchCountByCamera(startTime,endTime,0L,faceFeature,threshold);
    }

    @Override
    public long faceSearchCountByCamera(long startTime, long endTime, long cameraId, String faceFeature, double threshold) throws Exception {
        long beginTime = System.currentTimeMillis();
        long result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String searchStartTime = sdf.format(new Date(startTime - 3600*1000*8));
        searchStartTime = searchStartTime.replace(" ", "T");
        String searchEndTime = sdf.format(new Date(endTime - 3600*1000*8));
        searchEndTime = searchEndTime.replace(" ", "T");

        final StringBuffer logBuffer = new StringBuffer();
        final SolrQuery query = new SolrQuery();
        final List<Integer> finishList = Collections.synchronizedList(new ArrayList<>());
        final List<Long> resultList = Collections.synchronizedList(new ArrayList<>());

        query.setRequestHandler("/topsearch");
        query.set("fl", DEFAULT_FL);
        query.set("iff","true");
        query.set("threshold", String.valueOf(threshold));
        query.set("feature",faceFeature);
        query.set("featureAmount",faceFeature.split(";").length);

        // 1重点人员库
        String filterStr = "type:"+1;
        if(cameraId > 0){
            filterStr += " AND camera:"+cameraId;
        }
        filterStr += " AND time:[" + searchStartTime + "Z TO " + searchEndTime + "Z]";

        query.addFilterQuery(filterStr);

        logBuffer.append("检索记录：" + query.get("fq") + "\r\n");
        LOG.info("searchFaceByType, filterStr:" + filterStr);

        int num = 0;
        List<HttpSolrClient> allServer = getAllServer();
        query.setStart(0);
        query.setRows(0);


        for (final HttpSolrClient server : allServer) {
            threadPool.submit(() -> {
                try {
                    long now = System.currentTimeMillis();
                    QueryResponse response = server.query(query, METHOD.POST);
                    long numFound = Long.valueOf(response.getResponse().get("numFound").toString());
                    resultList.add(numFound);

                    logBuffer.append(sdf.format(new Date())+"	"+faceFeature.substring(0, 100)+" | "+server.getBaseURL() + " ---> "+(System.currentTimeMillis()-now)+" ms"+"\r\n");
                } catch (Exception e) {
                    LOG.error("",e);
                } finally {
                    finishList.add(1);
                }
            });
            num++;
        }
        // 等待任务线程全部执行完毕
        while (finishList.size() < num) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                LOG.error(e.getMessage());
            }
        }


        LOG.debug(logBuffer.toString());

        if(!CollectionUtils.isEmpty(resultList)){
            for(long count : resultList){
                result += count;
            }
        }
        LOG.info(">>>faceSearchCountByCamera result num:{} search cost time:{}",result, (System.currentTimeMillis()-beginTime));
        return result;
    }
}
