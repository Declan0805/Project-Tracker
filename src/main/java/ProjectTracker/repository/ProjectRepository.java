package ProjectTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectTracker.model.Project;
public interface ProjectRepository extends JpaRepository<Project, Integer>{
    
}