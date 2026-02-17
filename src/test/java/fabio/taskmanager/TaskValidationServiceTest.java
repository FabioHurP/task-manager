package fabio.taskmanager;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fabio.taskmanager.exception.DataInvalidException;
import fabio.taskmanager.model.Task;
import fabio.taskmanager.service.TaskValidationService;

public class TaskValidationServiceTest {

    private TaskValidationService taskVs;

    @BeforeEach
    void setUp() {
        taskVs = new TaskValidationService();
    }

    @Test
    @DisplayName("Should throw exception if id value is zero or null")
    void testValidateValueId_zero_null() {
        assertThrows(DataInvalidException.class, () -> taskVs.validateValueId(0));
        assertThrows(DataInvalidException.class, () -> taskVs.validateValueId(null));
    }

    @Test
    @DisplayName("Shouldn't  throw exception when id doesn't exist")
    void testvalidateIdMatch_IdDoesNotExist() {

        List<Task> tasks = List.of(
                new Task(1, "task 1"),
                new Task(2, "task 2")
        );

        assertDoesNotThrow(() ->
                taskVs.validateIdMatch(tasks, 3)
        );
    }

}
