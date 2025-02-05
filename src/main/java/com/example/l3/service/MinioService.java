package com.example.l3.service;

import org.springframework.web.multipart.MultipartFile;

public interface MinioService {
    String uploadImage(MultipartFile multipartFile) throws Exception;
    void deleteImage(String imageUrl) throws Exception;
}
