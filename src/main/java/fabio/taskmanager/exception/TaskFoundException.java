package fabio.taskmanager.exception;

public class TaskFoundException extends RuntimeException{

    public TaskFoundException(String mensaje) {
        super(mensaje);
    }

}
