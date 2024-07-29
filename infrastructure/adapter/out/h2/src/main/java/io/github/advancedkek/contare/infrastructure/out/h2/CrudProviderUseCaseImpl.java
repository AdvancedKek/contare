package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.ProviderStorage;
import io.github.advancedkek.contare.domain.Provider;
import io.github.advancedkek.contare.domain.exception.ProviderNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.ProviderEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudProviderUseCaseImpl implements ProviderStorage {

    private final ProviderRepository providerRepository;

    @Override
    public List<Provider> find(UUID id) {
        return providerRepository.findById(id)
                .map(ProviderEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<Provider> get() {
        return providerRepository.findAll().stream()
                .map(ProviderEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Provider create(Provider provider) {
        var newEntity = providerRepository.save(ProviderEntityConverter.toEntity(provider));
        return ProviderEntityConverter.toDomain(newEntity);
    }

    @Override
    public Provider update(Provider provider) {
        var isProviderExist = providerRepository.existsById(provider.getId());
        if (!isProviderExist) {
            var message = String.format("Provider with ID %s not found", provider.getId());
            throw new ProviderNotFoundException(message);
        }
        providerRepository.save(ProviderEntityConverter.toEntity(provider));
        return provider;
    }

    @Override
    public void delete(UUID id) {
        providerRepository.deleteById(id);
    }
}