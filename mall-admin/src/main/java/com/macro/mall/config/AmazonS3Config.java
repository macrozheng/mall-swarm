package com.macro.mall.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AWS S3 object storage related configuration
 * Created by macro on 2018/5/17.
 */
@Configuration
public class AmazonS3Config {

    // click on them, the file URL contains your bucket URL.
    @Value("${amazon.s3.endpoint}")
    private String url;

    // Your bucket name.
    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    // The IAM access key.
    @Value("${aws.s3.access-key}")
    private String accessKey;

    // The IAM secret key.
    @Value("${aws.s3.secret-key}")
    private String secretKey;

    // Region will be read from the application.yml file  during the application intialization.
    @Value("${aws.s3.region}")
    private String region;


    @Bean
    protected AmazonS3 amazonS3() {
        final BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
        // Get AmazonS3 client and return the s3Client object.
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }

}

