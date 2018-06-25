package com.intellif.jianyi.service;

public interface ShareSolrDataService{

	/**
	 * 统计检索所有摄像头符合相似度人脸的个数
	 * @param startTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @param faceFeature
	 * 			人脸特征值
	 * @param threshold
	 * 			相似度
	 * @return
	 * @throws Exception
	 */
	long faceSearchCountAll(long startTime,long endTime,String faceFeature, double threshold) throws Exception;

	/**
	 * 统计检索单个摄像头符合相似度人脸的个数
	 * @param startTime
	 * 			开始时间
	 * @param endTime
	 * 			结束时间
	 * @param cameraId
	 * 			摄像头ID
	 * @param faceFeature
	 * 			人脸特征值
	 * @param threshold
	 * 			相似度
	 * @return
	 * @throws Exception
	 */
	long faceSearchCountByCamera(long startTime,long endTime,long cameraId, String faceFeature, double threshold) throws Exception;

}
