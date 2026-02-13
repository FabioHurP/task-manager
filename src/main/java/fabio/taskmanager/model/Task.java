package fabio.taskmanager.model;

public class Task {
    private int id;
    private String description;
    private boolean state;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.state = false;
    }

    public int getId() {
        return id;
    }
    public String getdescription() {
        return description;
    }
    public boolean isstate() {
        return state;
    }

     public void setId(int id) {
        this.id = id;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public void setstate(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", description=" + description + ", state=" + state + "]";
    }


}
