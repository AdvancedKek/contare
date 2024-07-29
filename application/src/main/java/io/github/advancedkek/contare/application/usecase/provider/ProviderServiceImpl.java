package io.github.advancedkek.contare.application.usecase.providers;

import io.github.advancedkek.contare.application.port.in.CrudProviderUseCase;
import io.github.advancedkek.contare.application.port.out.ProviderStorage;
import io.github.advancedkek.contare.domain.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements CrudProviderUseCase {

    private final ProviderStorage providerStorage;

    @Override
    public List<Provider> getById(UUID id) {
        return providerStorage.find(id);
    }

    @Override
    public List<Provider> get() {
        return providerStorage.get();
    }

    @Override
    public Provider create(Provider provider) {
        return providerStorage.create(provider);
    }

    @Override
    public Provider update(Provider provider) {
        return providerStorage.update(provider);
    }

    @Override
    public void delete(UUID id) {
        providerStorage.delete(id);
    }
}
