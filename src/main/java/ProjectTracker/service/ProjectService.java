package ProjectTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ProjectTracker.model.Project;
@Service
public class ProjectService {
    private List<Project> projects = new ArrayList<>();
    public ProjectService(){
        projects.add(new Project(1, "Data Structures", "IN_PROGRESS"));
    }
    public Boolean createProject(Project project){
        for (Project existingProject : projects){
            if (existingProject.getId() == project.getId()){
                return false;
            }
        }
        projects.add(project);
        return true;
    }
    public List<Project> getProjects(){
        return projects;
    }
    public Project getProjectById(int id){
        for (Project project : projects){
            if (project.getId() == id){
                return project;
            }
        }
        return null;
    }
}