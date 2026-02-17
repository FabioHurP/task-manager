package fabio.taskmanager;

import fabio.taskmanager.model.Task;
import fabio.taskmanager.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("BIENVENIDO The Task Management System");

        TaskService service = new TaskService();

        service.createTask(new Task(1, "Create new task"));
        service.createTask(new Task(2, "Mark task as complete"));

        service.markTaskComplete(0, true);

        service.listAllTask().forEach(tarea -> log.info("{}", tarea));
    }
}