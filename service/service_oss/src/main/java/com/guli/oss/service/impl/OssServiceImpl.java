package com.guli.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.guli.oss.service.OssService;
import com.guli.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadFileAvatar(MultipartFile file) {
        String endPoint = ConstantPropertiesUtils.END_POINT;
        String keyId = ConstantPropertiesUtils.KEY_ID;
        String keySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;
        try {
            //创建OSS实例
            OSS ossClient = new OSSClientBuilder().build(endPoint,keyId,keySecret);
            InputStream inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            //在名称里添加随机的唯一值
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid+fileName;
            //把文件按照日期分类
            String dateTime = new DateTime().toString("yyyy/MM/dd");
            fileName = dateTime+"/"+fileName;
            //调用oss方法实现上传
            //第一个参数 Bucket名称
            //第二个参数 上传到oss文件路径和文件名称 /aa/bb/cc/1.jpg
            //第三个参数 上传文件输入流
            ossClient.putObject(bucketName,fileName,inputStream);
            //关闭OSSClient
            ossClient.shutdown();
            //把上传之后文件路径返回
            //需要把上传到阿里云oss路径手动拼接出来
            //https://guli-parent-1102.oss-cn-beijing.aliyuncs.com/%E4%B8%8B%E8%BD%BD.jfif
            String url = "https://"+bucketName+"."+endPoint+"/"+fileName;
            return url;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
