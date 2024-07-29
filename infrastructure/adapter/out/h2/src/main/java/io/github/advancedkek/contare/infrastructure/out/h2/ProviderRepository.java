package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.infrastructure.out.h2.domain.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<ProviderEntity, UUID> {
}
