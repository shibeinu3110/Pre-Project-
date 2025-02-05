package com.example.l3.service.impl;

import com.example.l3.service.MinioService;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    private final MinioClient minioClient;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Override
    public String uploadImage(MultipartFile file) throws Exception{
        String objectName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        // Lưu ảnh vào MinIO
        try (InputStream inputStream = file.getInputStream()) {
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
        }
        // Trả về URL của ảnh
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
    }


    @Override
    public void deleteImage(String imageUrl) throws Exception {
        // Tách tên đối tượng từ URL (loại bỏ phần tham số sau dấu `?`)
        String objectName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        if (objectName.contains("?")) {
            objectName = objectName.substring(0, objectName.indexOf("?"));
        }

        // Xóa ảnh từ MinIO
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build()
        );
    }



}
