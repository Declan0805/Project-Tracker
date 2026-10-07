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
    public boolean createProject(Project project){
        for (Project existingProject : projects){
            if (existingProject.getId() == project.getId()){
                return false;
            }
        }
        projects.add(project);
        return true;
    }
    public Project updateProject(int id, Project updatedProject){
        for (Project existingProject : projects){
            if (existingProject.getId() == id){
                existingProject.setStatus(updatedProject.getStatus());
                existingProject.setName(updatedProject.getName());
                return existingProject;
            }
        }
        return null;
    }
    public Project deleteProject(int id){
        for (int i=0; i<projects.size(); i++){
            Project project = projects.get(i);
            if (project.getId() == id){
                projects.remove(i);
                return project;
            }
        }
        return null;
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