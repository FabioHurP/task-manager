package fabio.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

// import org.slf4j.LoggerFactory;

import org.slf4j.*;
import fabio.taskmanager.model.Task;

public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    // private Task taskActual;
    private List<Task> tasks = new ArrayList<>();

    public void createTask(int id, String description) {
        log.info("Creating new Task {} {} ", id, description);
        // Tarea taskActual = new Task(id, description);
        tasks.add(new Task(id, description));
        log.info("task registrared with success");
    }

    public List<Task> listAllTask() {
        log.info("Listing all tasks");
        return tasks;
    }

    public void markTaskComplete(int id, boolean state) {
        log.info("Mark task as complete");
        Task task = searchTaskById(id);
        task.setstate(state);

    }

    public void deleteTask() {

    }

    public Task searchTaskById(int id) {
        final Task[] result = new Task[1];

        tasks.forEach(task -> {
            if (task.getId() == id) {
                result[0] = task;
            }
        });
        return result[0];
    }


}
