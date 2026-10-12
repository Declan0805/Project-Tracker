package ProjectTracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Project{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    
    public Project(Integer id, String name, ProjectStatus status){
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public Project(){

    }

    // Getters for Project values
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public ProjectStatus getStatus(){
        return status;
    }
    // Setters for Project values (the no arguments constructor)
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStatus(ProjectStatus status){
        this.status = status;
    }
}
