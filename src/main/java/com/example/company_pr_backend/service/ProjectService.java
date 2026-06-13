package com.example.company_pr_backend.service;

import com.example.company_pr_backend.dto.ProjectRequest;
import com.example.company_pr_backend.entity.Project;
import com.example.company_pr_backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(ProjectRequest request) {
        String slug = createSlug(request.getTitle());

        Project project = new Project(
                request.getTitle(),
                slug,
                request.getCategory(),
                request.getDescription(),
                request.getImage()
        );

        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllByOrderByIdDesc();
    }

    public Project getProjectBySlug(String slug) {
        return projectRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dự án"));
    }

    public Project updateProject(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dự án"));

        String slug = createSlug(request.getTitle());

        project.update(
                request.getTitle(),
                slug,
                request.getCategory(),
                request.getDescription(),
                request.getImage()
        );

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    private String createSlug(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);

        return normalized
                .replaceAll("\\p{M}", "")
                .replace("đ", "d")
                .replace("Đ", "d")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9\\s-]", "")
                .trim()
                .replaceAll("\\s+", "-");
    }
}