package com.macro.mall.controller;


import com.amazonaws.services.s3.AmazonS3;
import com.macro.mall.service.AmazonClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;

/**
 * Oss related operation interface
 * Created by macro on 2018/4/26.
 */
@RestController
@Api(tags = "AmazonS3Controller")
@RequestMapping("/aws/s3")
public class AmazonS3Controller {

    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    private String bucketLocation;

    @Autowired
    private AmazonClientService amazonClientService;

    @PostConstruct
    public void postConstruct() {
        this.bucketLocation = String.format("https://%s.s3.%s.amazonaws.com",
                bucketName, this.amazonS3.getBucketLocation(bucketName));
    }

    @ApiOperation(value = "AmazonS3 upload signature generation")
    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadFile(@RequestPart(value = "file") final MultipartFile multipartFile) {
        amazonClientService.uploadFile(multipartFile);
        final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
