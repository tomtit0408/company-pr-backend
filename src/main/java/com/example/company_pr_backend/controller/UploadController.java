package com.example.company_pr_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/uploads")

public class UploadController {

    @Value("${app.base-url}")
    private String appBaseUrl;

    @PostMapping("/project-image")
    public Map<String, String> uploadProjectImage(@RequestParam("file") MultipartFile file)
            throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File ảnh không được để trống");
        }

        String fileName = generateFileName(file);

        Path uploadPath = Paths.get(System.getProperty("user.dir"), "uploads", "projects");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        String imageUrl = appBaseUrl + "/uploads/projects/" + fileName;

        return Map.of("imageUrl", imageUrl);
    }

    @PostMapping("/banner-image")
    public Map<String, String> uploadBannerImage(@RequestParam("file") MultipartFile file)
            throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("File ảnh không được để trống");
        }

        String fileName = generateFileName(file);

        Path uploadPath = Paths.get(System.getProperty("user.dir"), "uploads", "banners");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        String imageUrl = appBaseUrl + "/uploads/banners/" + fileName;

        return Map.of("imageUrl", imageUrl);
    }

    private String generateFileName(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String extension = "";

        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        return UUID.randomUUID() + extension;
    }
}