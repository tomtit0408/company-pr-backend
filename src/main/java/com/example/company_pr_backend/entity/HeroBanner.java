package com.example.company_pr_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hero_banners")
public class HeroBanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String image;

    private Integer displayOrder;

    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public HeroBanner() {
    }

    public HeroBanner(
            String title,
            String subtitle,
            String description,
            String image,
            Integer displayOrder,
            String status
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.image = image;
        this.displayOrder = displayOrder;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(
            String title,
            String subtitle,
            String description,
            String image,
            Integer displayOrder,
            String status
    ) {
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.image = image;
        this.displayOrder = displayOrder;
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }
}