package dev.pluvial.kanban.task;

import javax.validation.constraints.NotBlank;

public class TaskDTO {

    @NotBlank
    private String summary;
    private String description;
    private Status status;

    public String getSummary() {
        return summary;
    }

    public TaskDTO setSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public TaskDTO setStatus(Status status) {
        this.status = status;
        return this;
    }
}
