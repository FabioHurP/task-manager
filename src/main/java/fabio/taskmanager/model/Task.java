package fabio.taskmanager.model;

public class Task {
    private String id;
    private String descripcion;
    private boolean estado;

    public Task(String id, String descripcion, boolean estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public boolean isEstado() {
        return estado;
    }

     public void setId(String id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
