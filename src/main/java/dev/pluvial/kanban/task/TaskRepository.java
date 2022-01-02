package dev.pluvial.kanban.task;

import dev.pluvial.kanban.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

/**
 * Interface for generic CRUD operations on a repository for a Task.
 */
public interface TaskRepository extends CrudRepository<Task, UUID> {

    /**
     * Finds all tasks for a user.
     * @param owner, user who created the task
     * @return List of tasks
     */
    List<Task> findByOwner(User owner);
}
