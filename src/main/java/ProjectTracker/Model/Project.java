package ProjectTracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String status;
    
    public Project(Integer id, String name, String status){
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
    public String getStatus(){
        return status;
    }
    // Setters for Project values (the no arguments constructor)
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
