package com.example.company_pr_backend.repository;

import com.example.company_pr_backend.entity.HeroBanner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeroBannerRepository extends JpaRepository<HeroBanner, Long> {

    List<HeroBanner> findAllByOrderByDisplayOrderAscIdDesc();

    List<HeroBanner> findByStatusOrderByDisplayOrderAscIdDesc(String status);
}