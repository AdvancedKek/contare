package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.TaskStorage;
import io.github.advancedkek.contare.domain.Task;
import io.github.advancedkek.contare.domain.exception.TaskNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.TaskEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudTaskUseCaseImpl implements TaskStorage {

    private final TaskRepository taskRepository;

    @Override
    public List<Task> find(UUID id) {
        return taskRepository.findById(id)
                .map(TaskEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<Task> get() {
        return taskRepository.findAll().stream()
                .map(TaskEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Task create(Task task) {
        var newEntity = taskRepository.save(TaskEntityConverter.toEntity(task));
        return TaskEntityConverter.toDomain(newEntity);
    }

    @Override
    public Task update(Task task) {
        var isTaskExist = taskRepository.existsById(task.getId());
        if (!isTaskExist) {
            var message = String.format("Task with ID %s not found", task.getId());
            throw new TaskNotFoundException(message);
        }
        taskRepository.save(TaskEntityConverter.toEntity(task));
        return task;
    }

    @Override
    public void delete(UUID id) {
        taskRepository.deleteById(id);
    }
}