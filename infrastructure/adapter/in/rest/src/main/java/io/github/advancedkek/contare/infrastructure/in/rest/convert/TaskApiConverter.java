package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateTaskRequest;
import io.github.advancedkek.contare.api.model.Task;
import io.github.advancedkek.contare.api.model.UpdateTaskRequest;

import java.util.UUID;

public class TaskApiConverter {

    public static Task toApi(io.github.advancedkek.contare.domain.Task model) {
        return new Task()
                .id(model.getId())
                .employerId(model.getEmployerId())
                .name(model.getName())
                .description(model.getDescription())
                .price(model.getPrice())
                .employeePrice(model.getEmployeePrice())
                .servicePrice(model.getServicePrice());
    }

    public static io.github.advancedkek.contare.domain.Task toDomain(CreateTaskRequest request) {
        return io.github.advancedkek.contare.domain.Task.builder()
                .employerId(request.getEmployerId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .employeePrice(request.getEmployeePrice())
                .servicePrice(request.getPrice())
                .build();
    }

    public static io.github.advancedkek.contare.domain.Task toDomain(UpdateTaskRequest request) {
        return io.github.advancedkek.contare.domain.Task.builder()
                .id(request.getId())
                .employerId(request.getEmployerId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .employeePrice(request.getEmployeePrice())
                .servicePrice(request.getServicePrice())
                .build();
    }
}
