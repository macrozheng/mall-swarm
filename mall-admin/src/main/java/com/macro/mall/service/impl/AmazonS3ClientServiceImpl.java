package com.macro.mall.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.macro.mall.service.AmazonClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;

/**
 * Amazon S3 service management implementation class
 * Created by macro on 2018/5/17.
 */

@Service
public class AmazonS3ClientServiceImpl implements AmazonClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonS3ClientServiceImpl.class);

    @Autowired
    private AmazonS3 amazonS3;
    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Override
    // @Async annotation ensures that the method is executed in a different background thread
    // but not consume the main thread.
    @Async
    public void uploadFile(final MultipartFile multipartFile) {
        LOGGER.info("File upload in progress.");
        try {
            final File file = convertMultiPartFileToFile(multipartFile);
            uploadFileToS3Bucket(bucketName, file);
            LOGGER.info("File upload is completed.");
            file.delete();  // To remove the file locally created in the project folder.
        } catch (final AmazonServiceException ex) {
            LOGGER.info("File upload is failed.");
            LOGGER.error("Error= {} while uploading file.", ex.getMessage());
        }
    }

    private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
        final File file = new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (final IOException ex) {
            LOGGER.error("Error converting the multi-part file to file= ", ex.getMessage());
        }
        return file;
    }

    private void uploadFileToS3Bucket(final String bucketName, final File file) {
        final String uniqueFileName = LocalDateTime.now() + "_" + file.getName();
        LOGGER.info("Uploading file with name= " + uniqueFileName);
        final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uniqueFileName, file);
        amazonS3.putObject(putObjectRequest);
    }
}