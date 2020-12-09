package com.macro.mall.controller;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.AmazonS3UploadDto;
import com.macro.mall.dto.BucketPolicyConfigDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Oss related operation interface
 * Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "AmazonS3Controller")
@RequestMapping("/aws/s3")
public class AmazonS3Controller {
    private static final Logger logger = LoggerFactory.getLogger(AmazonS3Controller.class);
    @Value("${aws.s3.bucketName}")
    private String bucketName;
    @Value("${aws.s3.endpoint}")
    private String url;

    @Autowired
    AmazonS3 amazonS3;

    private String keyName = null;

/*    @Profile("prod")
    @PostConstruct
    public void postConstruct() {
        this.bucketLocation = String.format("https://%s.s3.%s.amazonaws.com",
                bucketName, this.amazonS3.getBucketLocation(bucketName));
    }*/

    @ApiOperation("File Upload")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            //Create a S3 Java client

            boolean isExist = amazonS3.doesBucketExistV2(bucketName);
            if (isExist) {
                logger.info("The bucket already exists!");
            } else {
                //Create a bucket and set read-only permissions
                amazonS3.createBucket(bucketName);
                BucketPolicyConfigDto bucketPolicyConfigDto = createBucketPolicyConfigDto(bucketName);
                SetBucketPolicyRequest setBucketPolicyRequest = new SetBucketPolicyRequest(bucketName, JSONUtil.toJsonStr(bucketPolicyConfigDto));
                amazonS3.setBucketPolicy(setBucketPolicyRequest);
            }
            String filename = file.getOriginalFilename();
            String contentType = file.getContentType();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(contentType);
            objectMetadata.setContentLength(file.getSize());

            // Set the storage object name
            String objectName = sdf.format(new Date()) + "/" + filename;
            // Use put Object to upload a file to the bucket
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, file.getInputStream(), objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead);

            amazonS3.putObject(putObjectRequest);
            logger.info("File upload successfully!");
            AmazonS3UploadDto amazonS3UploadDto = new AmazonS3UploadDto();
            amazonS3UploadDto.setName(filename);
            amazonS3UploadDto.setUrl(url + "/" + bucketName + "/" + objectName);
            return CommonResult.success(amazonS3UploadDto);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Upload error: {}！", e.getMessage());
        }
        return CommonResult.failed();
    }

    private BucketPolicyConfigDto createBucketPolicyConfigDto(String bucketName) {
        BucketPolicyConfigDto.Statement statement = BucketPolicyConfigDto.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action("s3:GetObject")
                .Resource("arn:aws:s3:::" + bucketName + "/*.**").build();
        return BucketPolicyConfigDto.builder()
                .Version("2012-10-17")
                .Statement(CollUtil.toList(statement))
                .build();
    }

    @ApiOperation("File deletion")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        try {

//            amazonS3.deleteObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
            amazonS3.deleteObject(new DeleteObjectRequest(bucketName, keyName));
            return CommonResult.success(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonResult.failed();
    }

}
