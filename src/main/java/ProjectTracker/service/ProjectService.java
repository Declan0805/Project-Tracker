package ProjectTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ProjectTracker.model.Project;
import ProjectTracker.repository.ProjectRepository;
@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }
    public Project createProject(Project project){
        return projectRepository.save(project);
    }
    public Project updateProject(int id, Project updatedProject){
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()){
           Project project = existingProject.get();
           project.setName(updatedProject.getName());
           project.setStatus(updatedProject.getStatus());

           return projectRepository.save(project);
        }
        return null;
    }
    public Project deleteProject(int id){
        Optional<Project> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()){
            Project project = existingProject.get();
            projectRepository.delete(project);
            return project;
        }
        return null;
    }
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }
    public Project getProjectById(int id){
        Optional<Project> project = projectRepository.findById(id);
        
        return project.orElse(null);
    }
}