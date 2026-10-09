package ProjectTracker.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ProjectTracker.model.Project;
import ProjectTracker.service.ProjectService;

@RestController

public class ProjectController {
    private ProjectService projectService;
    
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id){
        Project project = projectService.getProjectById(id);
        if (project != null){
            return ResponseEntity.ok(project);
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project created = projectService.createProject(project);
        return ResponseEntity.status(201).body(created);
    }
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project updatedProject){
        Project updated = projectService.updateProject(id, updatedProject);
        if(updated != null){
            return ResponseEntity.ok(updated);

        }
        return ResponseEntity.notFound().build();
    } 
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id){
        Project deleted = projectService.deleteProject(id);
        if(deleted != null){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.notFound().build();
    }
}