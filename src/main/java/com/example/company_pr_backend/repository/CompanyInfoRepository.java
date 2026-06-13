package com.example.company_pr_backend.repository;

import com.example.company_pr_backend.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
}