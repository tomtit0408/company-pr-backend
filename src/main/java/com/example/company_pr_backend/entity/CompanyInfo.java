package com.example.company_pr_backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "company_info")
public class CompanyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String hotline;

    private String email;

    private String facebook;

    private String zalo;

    private String workingTime;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    private LocalDateTime updatedAt;

    public CompanyInfo() {
    }

    public CompanyInfo(
            String companyName,
            String address,
            String hotline,
            String email,
            String facebook,
            String zalo,
            String workingTime,
            String shortDescription
    ) {
        this.companyName = companyName;
        this.address = address;
        this.hotline = hotline;
        this.email = email;
        this.facebook = facebook;
        this.zalo = zalo;
        this.workingTime = workingTime;
        this.shortDescription = shortDescription;
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getHotline() {
        return hotline;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getZalo() {
        return zalo;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void update(
            String companyName,
            String address,
            String hotline,
            String email,
            String facebook,
            String zalo,
            String workingTime,
            String shortDescription
    ) {
        this.companyName = companyName;
        this.address = address;
        this.hotline = hotline;
        this.email = email;
        this.facebook = facebook;
        this.zalo = zalo;
        this.workingTime = workingTime;
        this.shortDescription = shortDescription;
        this.updatedAt = LocalDateTime.now();
    }
}