package ProjectTracker.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
                return project;
            }
        }
        return null;
    }
}