package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.infrastructure.out.h2.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
