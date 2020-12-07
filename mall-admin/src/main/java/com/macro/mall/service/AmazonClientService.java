package com.macro.mall.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

public interface AmazonClientService {

    // @Async annotation ensures that the method is executed in a different background thread
    // but not consume the main thread.
    @Async
    void uploadFile(MultipartFile multipartFile);
}
