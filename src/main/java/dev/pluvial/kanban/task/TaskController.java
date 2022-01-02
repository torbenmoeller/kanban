package dev.pluvial.kanban.task;

import dev.pluvial.kanban.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * REST interface for reading tasks on '/tasks'
 */
@RestController
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskController(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    /**
     * Reads all tasks.
     * @return List with all tasks.
    */
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        var user = userService.getLoggedInUser();
        return taskRepository.findByOwner(user);
    }

    /**
     * Reads one task.
     * @param uuid, id of the task
     * @return Task
     * @throws ResponseStatusException, if access is unoauthorized
     */
    @GetMapping("/tasks/{uuid}")
    public Task getTask(@PathVariable UUID uuid) {
        var user = userService.getLoggedInUser();
        var task = taskRepository.findById(uuid);
        if(task.isPresent() && task.get().getOwner() != user){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized to access task");
        }
        return task.orElseThrow();
    }

    /**
     * Creates a new task
     * @param taskDTO, data transfer object of a task
     */
    @PostMapping("/tasks")
    public void createTask(@Valid @RequestBody TaskDTO taskDTO) {
        var user = userService.getLoggedInUser();
        var task = new Task()
                .setOwner(user)
                .setSummary(taskDTO.getSummary())
                .setDescription(taskDTO.getDescription());
        taskRepository.save(task);
    }

    /**
     * Updates a task
     * @param uuid, id of the task to update
     * @param taskDTO, data which is used to update the task.
     */
    @PutMapping("/tasks/{uuid}")
    public void updateTask(@PathVariable UUID uuid, @Valid @RequestBody TaskDTO taskDTO) {
        var user = userService.getLoggedInUser();
        var task = taskRepository.findById(uuid);
        if(task.isPresent() && task.get().getOwner() != user){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unauthorized to access task");
        }
        taskRepository.save(task
                .get()
                .setSummary(taskDTO.getSummary())
                .setDescription(taskDTO.getDescription())
                .setStatus(taskDTO.getStatus())
        );
    }


}
