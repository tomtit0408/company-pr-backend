package com.example.company_pr_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String slug;

    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String image;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Project() {
    }

    public Project(String title, String slug, String category, String description, String image) {
        this.title = title;
        this.slug = slug;
        this.category = category;
        this.description = description;
        this.image = image;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return slug;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(String title, String slug, String category, String description, String image) {
        this.title = title;
        this.slug = slug;
        this.category = category;
        this.description = description;
        this.image = image;
        this.updatedAt = LocalDateTime.now();
    }
}