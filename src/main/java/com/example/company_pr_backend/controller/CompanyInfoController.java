package com.example.company_pr_backend.controller;

import com.example.company_pr_backend.dto.CompanyInfoRequest;
import com.example.company_pr_backend.entity.CompanyInfo;
import com.example.company_pr_backend.service.CompanyInfoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company-info")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class CompanyInfoController {

    private final CompanyInfoService companyInfoService;

    public CompanyInfoController(CompanyInfoService companyInfoService) {
        this.companyInfoService = companyInfoService;
    }

    @GetMapping
    public CompanyInfo getCompanyInfo() {
        return companyInfoService.getCompanyInfo();
    }

    @PutMapping
    public CompanyInfo updateCompanyInfo(@Valid @RequestBody CompanyInfoRequest request) {
        return companyInfoService.updateCompanyInfo(request);
    }
}