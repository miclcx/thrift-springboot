package com.intellif.jianyi.dao;

import com.intellif.jianyi.vo.SolrConfigInfo;

import java.util.List;


public interface SolrConfigDao {

    List<SolrConfigInfo> findAll();

    int totalSolrConfigCount();

    List<String> getSolrServerWithCameras();
	
}
