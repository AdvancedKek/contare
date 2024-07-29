package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateProviderRequest;
import io.github.advancedkek.contare.api.model.Provider;
import io.github.advancedkek.contare.api.model.UpdateProviderRequest;

public class ProviderApiConverter {

    public static Provider toApi(io.github.advancedkek.contare.domain.Provider model) {
        return new Provider()
                .id(model.getId())
                .name(model.getName())
                .phone(model.getPhone())
                .address(model.getAddress())
                .email(model.getEmail());
    }

    public static io.github.advancedkek.contare.domain.Provider toDomain(CreateProviderRequest request) {
        return io.github.advancedkek.contare.domain.Provider.builder()
                .name(request.getName())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }

    public static io.github.advancedkek.contare.domain.Provider toDomain(UpdateProviderRequest request) {
        return io.github.advancedkek.contare.domain.Provider.builder()
                .id(request.getId())
                .name(request.getName())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }
}
