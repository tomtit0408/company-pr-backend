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

    private String location;

    private String year;

    @Column(columnDefinition = "TEXT")
    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Project() {
    }

    public Project(
            String title,
            String slug,
            String category,
            String location,
            String year,
            String image,
            String description
    ) {
        this.title = title;
        this.slug = slug;
        this.category = category;
        this.location = location;
        this.year = year;
        this.image = image;
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public String getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(
            String title,
            String slug,
            String category,
            String location,
            String year,
            String image,
            String description
    ) {
        this.title = title;
        this.slug = slug;
        this.category = category;
        this.location = location;
        this.year = year;
        this.image = image;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }
}