package com.example.company_pr_backend.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

@RestController
public class ImageController {

    @GetMapping("/uploads/projects/{fileName:.+}")
    public ResponseEntity<Resource> getProjectImage(@PathVariable String fileName)
            throws MalformedURLException {

        Path imagePath = Paths
                .get(System.getProperty("user.dir"), "uploads", "projects", fileName)
                .toAbsolutePath()
                .normalize();

        Resource resource = new UrlResource(imagePath.toUri());

        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        String contentType = "image/jpeg";

        try {
            String detectedType = Files.probeContentType(imagePath);
            if (detectedType != null) {
                contentType = detectedType;
            }
        } catch (IOException ignored) {
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
    @GetMapping("/uploads/banners/{fileName:.+}")
public ResponseEntity<Resource> getBannerImage(@PathVariable String fileName)
        throws MalformedURLException {

    Path imagePath = Paths
            .get(System.getProperty("user.dir"), "uploads", "banners", fileName)
            .toAbsolutePath()
            .normalize();

    Resource resource = new UrlResource(imagePath.toUri());

    if (!resource.exists()) {
        return ResponseEntity.notFound().build();
    }

    String contentType = "image/jpeg";

    try {
        String detectedType = Files.probeContentType(imagePath);
        if (detectedType != null) {
            contentType = detectedType;
        }
    } catch (IOException ignored) {
    }

    return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(contentType))
            .body(resource);
}
}