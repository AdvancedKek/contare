package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.TaskApiDelegate;
import io.github.advancedkek.contare.api.model.CreateTaskRequest;
import io.github.advancedkek.contare.api.model.TaskResponse;
import io.github.advancedkek.contare.api.model.TasksResponse;
import io.github.advancedkek.contare.api.model.UpdateTaskRequest;
import io.github.advancedkek.contare.application.port.in.CrudTaskUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.TaskApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskApiDelegateImpl implements TaskApiDelegate {

    private final CrudTaskUseCase taskUseCase;

    @Override
    public ResponseEntity<TaskResponse> addTask(CreateTaskRequest createTaskRequest) {
        var task = taskUseCase.create(TaskApiConverter.toDomain(createTaskRequest));
        return ResponseEntity.ok(
                new TaskResponse(
                        TaskApiConverter.toApi(task)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteTask(UUID id) {
        taskUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TasksResponse> getTaskById(UUID id) {
        var tasks = Optional.ofNullable(id)
                .map(taskUseCase::getById)
                .orElse(taskUseCase.get());
        var tasksResponse = new TasksResponse(tasks.stream()
                .map(TaskApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(tasksResponse);
    }

    @Override
    public ResponseEntity<TaskResponse> updateTask(UpdateTaskRequest updateTaskRequest) {
        var task = taskUseCase.update(TaskApiConverter.toDomain(updateTaskRequest));
        return ResponseEntity.ok(
                new TaskResponse(
                        TaskApiConverter.toApi(task)
                )
        );
    }
}