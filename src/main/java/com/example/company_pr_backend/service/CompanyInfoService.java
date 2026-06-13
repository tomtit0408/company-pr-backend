package com.example.company_pr_backend.service;

import com.example.company_pr_backend.dto.CompanyInfoRequest;
import com.example.company_pr_backend.entity.CompanyInfo;
import com.example.company_pr_backend.repository.CompanyInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService {

    private final CompanyInfoRepository companyInfoRepository;

    public CompanyInfoService(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfoRepository.findById(1L)
                .orElseGet(() -> {
                    CompanyInfo defaultInfo = new CompanyInfo(
                            "Công ty TNHH Cơ Điện Lạnh Bình Hưng",
                            "109 Bến Nôm, Phường Rạch Dừa, Thành phố Vũng Tàu, Tỉnh Bà Rịa - Vũng Tàu",
                            "0900 000 000",
                            "binhhungdienlanh@gmail.com",
                            "",
                            "",
                            "Thứ 2 - Chủ nhật: 7:30 - 18:00",
                            "Đơn vị chuyên thi công, lắp đặt, sửa chữa, bảo trì và bảo dưỡng hệ thống điện lạnh dân dụng, thương mại và công nghiệp."
                    );

                    return companyInfoRepository.save(defaultInfo);
                });
    }

    public CompanyInfo updateCompanyInfo(CompanyInfoRequest request) {
        CompanyInfo companyInfo = getCompanyInfo();

        companyInfo.update(
                request.getCompanyName(),
                request.getAddress(),
                request.getHotline(),
                request.getEmail(),
                request.getFacebook(),
                request.getZalo(),
                request.getWorkingTime(),
                request.getShortDescription()
        );

        return companyInfoRepository.save(companyInfo);
    }
}