package dev.pluvial.kanban.task;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.pluvial.kanban.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * Entity class of Task
 * Describes a task and its status on the board
 */
@Entity
public class Task {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnore
    private User owner;

    @NotBlank
    private String summary;

    private String description;

    private Status status = Status.TO_DO;

    public UUID getId() {
        return id;
    }

    public Task setId(UUID id) {
        this.id = id;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Task setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public Task setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Task setStatus(Status status) {
        this.status = status;
        return this;
    }
}
