package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.Provider;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.ProviderEntity;

public class ProviderEntityConverter {

    public static ProviderEntity toEntity(Provider model) {
        return new ProviderEntity()
                .setId(model.getId())
                .setName(model.getName())
                .setPhone(model.getPhone())
                .setAddress(model.getAddress())
                .setEmail(model.getEmail());
    }

    public static Provider toDomain(ProviderEntity entity) {
        return Provider.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .build();
    }
}
