package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.ProviderApiDelegate;
import io.github.advancedkek.contare.api.model.CreateProviderRequest;
import io.github.advancedkek.contare.api.model.ProviderResponse;
import io.github.advancedkek.contare.api.model.ProvidersResponse;
import io.github.advancedkek.contare.api.model.UpdateProviderRequest;
import io.github.advancedkek.contare.application.port.in.CrudProviderUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.ProviderApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProviderApiDelegateImpl implements ProviderApiDelegate {

    private final CrudProviderUseCase providerUseCase;

    @Override
    public ResponseEntity<ProviderResponse> addProvider(CreateProviderRequest createProviderRequest) {
        var provider = providerUseCase.create(ProviderApiConverter.toDomain(createProviderRequest));
        return ResponseEntity.ok(
                new ProviderResponse(
                        ProviderApiConverter.toApi(provider)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteProvider(UUID id) {
        providerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProvidersResponse> getProviderById(UUID id) {
        var providers = Optional.ofNullable(id)
                .map(providerUseCase::getById)
                .orElse(providerUseCase.get());
        var providersResponse = new ProvidersResponse(providers.stream()
                .map(ProviderApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(providersResponse);
    }

    @Override
    public ResponseEntity<ProviderResponse> updateProvider(UpdateProviderRequest updateProviderRequest) {
        var provider = providerUseCase.update(ProviderApiConverter.toDomain(updateProviderRequest));
        return ResponseEntity.ok(
                new ProviderResponse(
                        ProviderApiConverter.toApi(provider)
                )
        );
    }
}