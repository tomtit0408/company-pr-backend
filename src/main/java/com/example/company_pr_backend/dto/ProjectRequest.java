package com.example.company_pr_backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectRequest {

    @NotBlank(message = "Tên dự án không được để trống")
    private String title;

    @NotBlank(message = "Danh mục dự án không được để trống")
    private String category;

    private String location;

    private String year;

    @NotBlank(message = "Hình ảnh dự án không được để trống")
    private String image;

    @NotBlank(message = "Mô tả dự án không được để trống")
    private String description;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}