package fabio.taskmanager;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fabio.taskmanager.exception.TaskNotFoundException;
import fabio.taskmanager.model.Task;
import fabio.taskmanager.service.TaskService;

public class TaskServiceTest {
    
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    @DisplayName("Should return task when task exist with given id")
    void testsearchTaskById_WhenTaskExists() {

        Task task1 = new Task(1, "task 1");
        Task task2 = new Task(2, "task 2");

        taskService.createTask(task1);
        taskService.createTask(task2);

        Task result = taskService.searchTaskById(2);

        assertNotNull(result);
        assertEquals(2, result.getId());
        assertEquals("task 2", result.getdescription());
    }

}
