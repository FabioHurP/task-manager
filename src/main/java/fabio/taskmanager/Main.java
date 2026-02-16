package fabio.taskmanager;

import fabio.taskmanager.service.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello world!");

        TaskService service = new TaskService();

        service.createTask(1, "Create new task");
        service.createTask(0, "Mark task as complete");

        service.markTaskComplete(2, true);

        // service.listAllTask().forEach(tarea -> log.info(tarea.toString()));
        service.listAllTask().forEach(tarea -> log.info("{}", tarea));

    
    }
}