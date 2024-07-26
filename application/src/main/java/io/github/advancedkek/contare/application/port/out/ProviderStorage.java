package io.github.advancedkek.contare.application.port.out;

import io.github.advancedkek.contare.domain.Provider;

import java.util.List;
import java.util.UUID;

public interface ProviderStorage {
    List<Provider> find(UUID id);
    List<Provider> get();
    Provider create(Provider provider);
    Provider update(Provider provider);
    void delete(UUID id);
}
