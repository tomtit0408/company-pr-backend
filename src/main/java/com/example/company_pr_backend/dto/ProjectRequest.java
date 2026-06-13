package com.example.company_pr_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequest {

    @NotBlank(message = "Tên dự án không được để trống")
    private String title;

    @NotBlank(message = "Loại dự án không được để trống")
    private String category;

    @NotBlank(message = "Mô tả dự án không được để trống")
    private String description;

    @NotBlank(message = "Hình ảnh dự án không được để trống")
    private String image;

    public ProjectRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}