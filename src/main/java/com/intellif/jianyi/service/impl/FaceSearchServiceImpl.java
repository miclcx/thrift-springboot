package com.intellif.jianyi.service.impl;

import com.intellif.jianyi.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.ByteBuffer;

/**
 * 服务实现类
 */
@Service
public class FaceSearchServiceImpl implements FaceSearchService.Iface {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private ShareSolrDataService shareSolrDataService;

    @Override
    public ReturnResult testConnect() throws TException {
        return new ReturnResult();
    }

    @Override
    public FaceSearchCountResult faceSearchCountAll(long startTime, long endTime, ByteBuffer faceFeature, int algVersion, double threshold) throws TException {
        logger.info("startTime={},endTime={},algVerson={},threshold={},faceFeature={}",
                startTime,endTime,algVersion,threshold,faceFeature);
        FaceSearchCountResult result = new FaceSearchCountResult();
        String feature = getFeatureBase64(faceFeature,algVersion);
        long count = 0;
        try {
            count = shareSolrDataService.faceSearchCountAll(startTime,endTime,feature,threshold);
        } catch (Exception e) {
            logger.error("",e);
            return new FaceSearchCountResult(new ReturnResult(-1,new SysException("系统异常")),0);
        }
        result.setCount(count);
        result.setReturnResult(new ReturnResult());
        return result;
    }

    private String getFeatureBase64(ByteBuffer faceFeature,int algVersion){
        String feature = "";
        feature += String.valueOf(algVersion);
        feature += "@";
        feature += DatatypeConverter.printBase64Binary(faceFeature.array());
        return feature;
    }

    @Override
    public FaceSearchCountResult faceSearchCountByCamera(long cameraId, long startTime, long endTime, ByteBuffer faceFeature, int algVersion, double threshold) throws TException {
        logger.info("cameraId={},startTime={},endTime={},algVerson={},threshold={},faceFeature={}",
                cameraId,startTime,endTime,algVersion,threshold,faceFeature);

        FaceSearchCountResult result = new FaceSearchCountResult();
        String feature = getFeatureBase64(faceFeature,algVersion);
        long count = 0;
        try {
            count = shareSolrDataService.faceSearchCountByCamera(startTime,endTime,cameraId,feature,threshold);
        } catch (Exception e) {
            logger.error("",e);
            return new FaceSearchCountResult(new ReturnResult(-1,new SysException("系统异常")),0);
        }
        result.setCount(count);
        result.setReturnResult(new ReturnResult());
        return result;
    }
}
