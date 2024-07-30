package io.github.advancedkek.contare.application.usecase.tasks;

import io.github.advancedkek.contare.application.port.in.CrudTaskUseCase;
import io.github.advancedkek.contare.application.port.out.TaskStorage;
import io.github.advancedkek.contare.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements CrudTaskUseCase {

    private final TaskStorage taskStorage;

    @Override
    public List<Task> getById(UUID id) {
        return taskStorage.find(id);
    }

    @Override
    public List<Task> get() {
        return taskStorage.get();
    }

    @Override
    public Task create(Task task) {
        return taskStorage.create(task);
    }

    @Override
    public Task update(Task task) {
        return taskStorage.update(task);
    }

    @Override
    public void delete(UUID id) {
        taskStorage.delete(id);
    }
}
