package com.example.company_pr_backend.repository;

import com.example.company_pr_backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByOrderByIdDesc();

    Optional<Project> findBySlug(String slug);
}