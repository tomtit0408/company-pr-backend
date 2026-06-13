package com.example.company_pr_backend.service;

import com.example.company_pr_backend.dto.ProjectRequest;
import com.example.company_pr_backend.entity.Project;
import com.example.company_pr_backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAllByOrderByIdDesc();
    }

    public Optional<Project> getProjectBySlug(String slug) {
        return projectRepository.findBySlug(slug);
    }

    public Project createProject(ProjectRequest request) {
        String slug = createSlug(request.getTitle());

        Project project = new Project(
                request.getTitle(),
                slug,
                request.getCategory(),
                request.getLocation(),
                request.getYear(),
                request.getImage(),
                request.getDescription()
        );

        return projectRepository.save(project);
    }

    public Project updateProject(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dự án"));

        String slug = createSlug(request.getTitle());

        project.update(
                request.getTitle(),
                slug,
                request.getCategory(),
                request.getLocation(),
                request.getYear(),
                request.getImage(),
                request.getDescription()
        );

        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    private String createSlug(String text) {
        String nowhitespace = text.trim().replaceAll("\\s+", "-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);

        String slug = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
                .matcher(normalized)
                .replaceAll("");

        slug = slug.toLowerCase(Locale.ENGLISH)
                .replaceAll("đ", "d")
                .replaceAll("[^a-z0-9-]", "")
                .replaceAll("-+", "-");

        return slug;
    }
}