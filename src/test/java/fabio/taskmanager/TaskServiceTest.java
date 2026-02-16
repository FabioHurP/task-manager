package fabio.taskmanager;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fabio.taskmanager.model.Task;
import fabio.taskmanager.service.TaskService;

public class TaskServiceTest {
    
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    // @Test
    // @DisplayName("Should throw exception if can't create new task")
    // void testShouldThrowExceptionIfCantCreateNewTask() {

    //     Task newTask = new Task(2, "nueva tarea");
    //     assertThrows(null, null)
    //     // taskService.createTask(newTask);

    // }

    @Test
    @DisplayName("Should throw exception if can mark task as complete")
    void markTaskComplete_ShouldNotThrowException_WhenTaskNotExists() {

        TaskService service = new TaskService();

        assertDoesNotThrow(() -> {
            service.markTaskComplete(99, true);
        });
    }

}
