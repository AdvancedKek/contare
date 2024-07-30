package io.github.advancedkek.contare.application.port.in;

import io.github.advancedkek.contare.domain.Task;

import java.util.List;
import java.util.UUID;

public interface CrudTaskUseCase {
    List<Task> getById(UUID id);
    List<Task> get();
    Task create(Task task);
    Task update(Task task);
    void delete(UUID id);
}
