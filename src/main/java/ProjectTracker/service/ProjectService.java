package ProjectTracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ProjectTracker.model.Project;
import ProjectTracker.repository.ProjectRepository;
@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    public boolean createProject(Project project){
        return projectRepository.create(project);
    }
    public Project updateProject(int id, Project updatedProject){
        return projectRepository.updateProject(id, updatedProject);
    }
    public Project deleteProject(int id){
        return projectRepository.deleteProject(id);
    }
    public List<Project> getProjects(){
        return projectRepository.getProjects();
    }
    public Project getProjectById(int id){
        return projectRepository.getProjectById(id);
    }
}