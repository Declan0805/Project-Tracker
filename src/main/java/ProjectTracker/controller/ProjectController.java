package ProjectTracker.controller;
import java.util.ArrayList;
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

@RestController

public class ProjectController {
    List<Project> projects = new ArrayList<>();
    public ProjectController(){
        projects.add(new Project(1,"Data Structures", "IN_PROGRESS"));
    }
    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projects;
    }
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id){
        for (Project project : projects) { 
            if (project.getId() == id){
                return ResponseEntity.ok(project);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        for(Project existingProject : projects){
            if (existingProject.getId() == project.getId()){
                return ResponseEntity.status(409).build();
            }
        }
        projects.add(project);
        return ResponseEntity.status(201).body(project);
    }
    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project updatedProject){
        for (Project project : projects){
            if (project.getId() == id){
                project.setName(updatedProject.getName());
                project.setStatus(updatedProject.getStatus());
                return ResponseEntity.ok(project);
            }
        }
        return ResponseEntity.notFound().build();
    } 
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id){
        for (int i=0; i < projects.size(); i++){
            Project project = projects.get(i);
            if (project.getId() == id){
                projects.remove(i);
                return ResponseEntity.status(204).build();
            }
        }
        return ResponseEntity.status(404).build();
    }
}