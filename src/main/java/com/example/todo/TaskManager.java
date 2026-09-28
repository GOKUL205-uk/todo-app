package com.example.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task add(String description) {
        Task task = new Task(nextId++, description);
        tasks.add(task);
        return task;
    }

    public boolean complete(int id) {
        Optional<Task> task = find(id);
        task.ifPresent(Task::markDone);
        return task.isPresent();
    }

    public boolean remove(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public List<Task> all() {
        return List.copyOf(tasks);
    }

    private Optional<Task> find(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }
}
