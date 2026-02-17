package fabio.taskmanager.service;

import java.util.List;

import org.slf4j.*;

import fabio.taskmanager.exception.DataInvalidException;
import fabio.taskmanager.exception.TaskFoundException;
import fabio.taskmanager.model.Task;

public class TaskValidationService {

    public static final Logger LOG = LoggerFactory.getLogger(TaskValidationService.class);


    public void validateValueId(Integer id) {
        if (id == null || id == 0) {
            LOG.warn("Validation failed: empty or null id");
            throw new DataInvalidException("The appointment identifier can't be empty.");
        }
    }

    public void validateDescription(String description) {
        LOG.warn("validating task description");
        if (description == null || description.isEmpty()) {
            throw new DataInvalidException("The description can't be null nor empty");
        }
    }

    public void validateIdMatch( List<Task> tasks, int id) {
        LOG.warn("validating task match");
        for (Task task : tasks) {
            if (task.getId() == id) {
                throw new TaskFoundException(
                        "The Task with id " + id + " ALREADY EXISTS.");
            }
        }
    }
}
