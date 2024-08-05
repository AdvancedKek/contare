package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.infrastructure.out.h2.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}
