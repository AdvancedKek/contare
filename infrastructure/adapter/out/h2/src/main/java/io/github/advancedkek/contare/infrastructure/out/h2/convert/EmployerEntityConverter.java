package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.Employer;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.EmployerEntity;

public class EmployerEntityConverter {

    public static EmployerEntity toEntity(Employer model) {
        return new EmployerEntity()
                .setId(model.getId())
                .setFirstName(model.getFirstName())
                .setLastName(model.getLastName())
                .setPatronymic(model.getPatronymic())
                .setPhone(model.getPhone())
                .setAddress(model.getAddress())
                .setEmail(model.getEmail());
    }

    public static Employer toDomain(EmployerEntity entity) {
        return Employer.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .patronymic(entity.getPatronymic())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .email(entity.getEmail())
                .build();
    }
}
