package com.example.company_pr_backend.controller;

import com.example.company_pr_backend.dto.HeroBannerRequest;
import com.example.company_pr_backend.entity.HeroBanner;
import com.example.company_pr_backend.service.HeroBannerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
public class HeroBannerController {

    private final HeroBannerService heroBannerService;

    public HeroBannerController(HeroBannerService heroBannerService) {
        this.heroBannerService = heroBannerService;
    }

    @GetMapping
    public List<HeroBanner> getAllBanners() {
        return heroBannerService.getAllBanners();
    }

    @GetMapping("/active")
    public List<HeroBanner> getActiveBanners() {
        return heroBannerService.getActiveBanners();
    }

    @PostMapping
    public HeroBanner createBanner(@Valid @RequestBody HeroBannerRequest request) {
        return heroBannerService.createBanner(request);
    }

    @PutMapping("/{id}")
    public HeroBanner updateBanner(
            @PathVariable Long id,
            @Valid @RequestBody HeroBannerRequest request
    ) {
        return heroBannerService.updateBanner(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBanner(@PathVariable Long id) {
        heroBannerService.deleteBanner(id);
    }
}