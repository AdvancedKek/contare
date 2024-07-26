package io.github.advancedkek.contare.application.port.in;

import io.github.advancedkek.contare.domain.Provider;

import java.util.List;
import java.util.UUID;

public interface CrudProviderUseCase {
    List<Provider> getById(UUID id);
    List<Provider> get();
    Provider create(Provider provider);
    Provider update(Provider provider);
    void delete(UUID id);
}
