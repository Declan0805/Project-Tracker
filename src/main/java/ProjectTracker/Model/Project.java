package ProjectTracker.model;

public class Project{
    private int id;
    private String name;
    private String status;
    
    public Project(int id, String name, String status){
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public Project(){

    }

    // Getters for Project values
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getStatus(){
        return status;
    }
    // Setters for Project values (the no arguments constructor)
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setStatus(String status){
        this.status = status;
    }
}
