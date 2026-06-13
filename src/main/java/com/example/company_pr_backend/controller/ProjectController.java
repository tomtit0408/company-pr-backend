package com.example.company_pr_backend.controller;

import com.example.company_pr_backend.dto.ProjectRequest;
import com.example.company_pr_backend.entity.Project;
import com.example.company_pr_backend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})

public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@Valid @RequestBody ProjectRequest request) {
        return projectService.createProject(request);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{slug}")
    public Project getProjectBySlug(@PathVariable String slug) {
        return projectService.getProjectBySlug(slug);
    }

    @PutMapping("/{id}")
    public Project updateProject(
            @PathVariable Long id,
            @Valid @RequestBody ProjectRequest request
    ) {
        return projectService.updateProject(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
}