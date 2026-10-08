package ProjectTracker.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ProjectTracker.model.Project;


@Repository
public class ProjectRepository{
    private List<Project> projects = new ArrayList<>();

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
    public void save(Project project){
        projects.add(project);
    }
    public boolean  create(Project project){
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
}