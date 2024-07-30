package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.Task;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.TaskEntity;

public class TaskEntityConverter {

    public static TaskEntity toEntity(Task model) {
        return new TaskEntity()
                .setId(model.getId())
                .setEmployerId(model.getEmployerId())
                .setName(model.getName())
                .setDescription(model.getDescription())
                .setPrice(model.getPrice())
                .setEmployeePrice(model.getEmployeePrice())
                .setServicePrice(model.getServicePrice());
    }

    public static Task toDomain(TaskEntity entity) {
        return Task.builder()
                .id(entity.getId())
                .employerId(entity.getEmployerId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .employeePrice(entity.getEmployeePrice())
                .servicePrice(entity.getServicePrice())
                .build();
    }
}
