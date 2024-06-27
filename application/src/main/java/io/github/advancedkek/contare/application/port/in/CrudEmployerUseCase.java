package io.github.advancedkek.contare.application.port.in;

import io.github.advancedkek.contare.domain.Employer;

import java.util.List;
import java.util.UUID;

public interface CrudEmployerUseCase {
    List<Employer> getById(UUID id);
    List<Employer> get();
    Employer create(Employer employer);
    Employer update(Employer employer);
    void delete(UUID id);
}
