package fabio.taskmanager.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String mensaje) {
        super(mensaje);
    }

}
