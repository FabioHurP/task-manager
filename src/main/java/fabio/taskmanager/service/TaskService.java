package fabio.taskmanager.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// import org.slf4j.LoggerFactory;

import org.slf4j.*;

import fabio.taskmanager.exception.DataInvalidException;
import fabio.taskmanager.exception.TaskFoundException;
import fabio.taskmanager.exception.TaskNotFoundException;
import fabio.taskmanager.model.Task;

public class TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);
    private List<Task> tasks = new ArrayList<>();
    private final TaskValitacionService taskValidation = new TaskValitacionService();

    public void createTask(int id, String description) {
        LOG.warn("Creating new Task {} {} ", id, description);
        try {
            validations(id, description);
            tasks.add(new Task(id, description));
            LOG.info("task registrared with success");
        } catch (DataInvalidException e) {
            LOG.error("Error creating task with {}: {}", id, e.getMessage());
        } catch (TaskFoundException e) {
            LOG.error("Error creating task with id {}: {}", id, e.getMessage());
        }
        
    }

    public List<Task> listAllTask() {
        LOG.info("Listing all tasks");
        return tasks;
    }

    public void markTaskComplete(int id, boolean state) {
        LOG.warn("Init processing  to Mark task as complete");
        try {
            Task task = searchTaskById(id);
            task.setstate(state);
            LOG.info("Task {} processed  successfully}", id);
        } catch (TaskNotFoundException e) {
            LOG.error("Error processing task {}: {}", id, e.getMessage());
        }
    }

    public void deleteTask(int id) {
        LOG.info("Init processing to delete task");
        try {
            Task task = searchTaskById(id);
            tasks.remove(task);
            LOG.info("Task {} deleted  successfully}", id);
        } catch (TaskNotFoundException e) {
            LOG.error("Error processin task {}: {}", id, e.getMessage());
        }
    }

    public Task searchTaskById(int id) {

        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
    
        throw new TaskNotFoundException("The Task with id " + id + " wasn't found.");        
    }

    public void validations(int id, String description) {
        taskValidation.validateValueId(id);
        taskValidation.validateDescription(description);
        taskValidation.validateIdMatch(tasks, id);        
    }


}
