namespace java com.intellif.jianyi.service
namespace cpp  com.intellif.jianyi.service

# 系统异常
struct SysException{
   1:string sysErrMsg
}
# 通用返回结构体
struct ReturnResult {
	1:i32 ackResult	   							                       # 执行结果 0:成功  负-1:失败
	2:SysException sysErrMsg                                           # 无异常为 null
}
# 人脸检索结果个数返回结构体
struct FaceSearchCountResult{
     1:ReturnResult                    returnResult                        # 接口执行返回对象，定义在common.thrift文件中
     2:i64                             count                               # 人脸个数
}

### 人脸检索服务接口
service FaceSearchService {
     
     # 测试连接
     ReturnResult testConnect();
     
     # 统计检索所有摄像头符合相似度人脸的个数
     # 输入参数：         
     #                   startTime           -- 开始时间
     #                   endTime             -- 结束时间
     #                   faceFeature         -- 人脸特征值
     #                   algVersion          -- 算法版本
     #                   threshold           -- 相似度阈值，如0.92
     # 接口说明：
     # 返回结构体定义在：face.thrift文件中
     FaceSearchCountResult  faceSearchCountAll(1:required i64 startTime,2:required i64 endTime, 3:required binary faceFeature,4:required i32 algVersion,5:required double threshold);

     # 统计检索单个摄像头符合相似度人脸的个数
     # 输入参数：
     #                   cameraId            -- 摄像头id
     #                   startTime           -- 开始时间
     #                   endTime             -- 结束时间
     #                   faceFeature         -- 人脸特征值
     #                   algVersion          -- 算法版本
     #                   threshold           -- 相似度阈值，如0.92
     # 接口说明：
     # 返回结构体定义在：face.thrift文件中
     FaceSearchCountResult  faceSearchCountByCamera(1:required i64 cameraId,2:required i64 startTime,3:required i64 endTime, 4:required binary faceFeature,5:required i32 algVersion,6:required double threshold);
     

}