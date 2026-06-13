package com.example.company_pr_backend.service;

import com.example.company_pr_backend.dto.HeroBannerRequest;
import com.example.company_pr_backend.entity.HeroBanner;
import com.example.company_pr_backend.repository.HeroBannerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroBannerService {

    private final HeroBannerRepository heroBannerRepository;

    public HeroBannerService(HeroBannerRepository heroBannerRepository) {
        this.heroBannerRepository = heroBannerRepository;
    }

    public List<HeroBanner> getAllBanners() {
        return heroBannerRepository.findAllByOrderByDisplayOrderAscIdDesc();
    }

    public List<HeroBanner> getActiveBanners() {
    return heroBannerRepository.findAllByOrderByDisplayOrderAscIdDesc();
}
    public HeroBanner createBanner(HeroBannerRequest request) {
        String status = request.getStatus();

        if (status == null || status.isBlank()) {
            status = "Hiển thị";
        }

        HeroBanner banner = new HeroBanner(
                request.getTitle(),
                request.getSubtitle(),
                request.getDescription(),
                request.getImage(),
                request.getDisplayOrder(),
                status
        );

        return heroBannerRepository.save(banner);
    }

    public HeroBanner updateBanner(Long id, HeroBannerRequest request) {
        HeroBanner banner = heroBannerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy banner"));

        String status = request.getStatus();

        if (status == null || status.isBlank()) {
            status = "Hiển thị";
        }

        banner.update(
                request.getTitle(),
                request.getSubtitle(),
                request.getDescription(),
                request.getImage(),
                request.getDisplayOrder(),
                status
        );

        return heroBannerRepository.save(banner);
    }

    public void deleteBanner(Long id) {
        heroBannerRepository.deleteById(id);
    }
}