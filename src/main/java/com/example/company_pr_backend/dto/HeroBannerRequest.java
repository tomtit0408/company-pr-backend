package com.example.company_pr_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HeroBannerRequest {

    @NotBlank(message = "Tiêu đề banner không được để trống")
    private String title;

    @NotBlank(message = "Phụ đề banner không được để trống")
    private String subtitle;

    @NotBlank(message = "Mô tả banner không được để trống")
    private String description;

    @NotBlank(message = "Hình ảnh banner không được để trống")
    private String image;

    @NotNull(message = "Thứ tự hiển thị không được để trống")
    private Integer displayOrder;

    private String status;

    public HeroBannerRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}