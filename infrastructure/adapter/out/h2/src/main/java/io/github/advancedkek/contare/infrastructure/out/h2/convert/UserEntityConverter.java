package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.User;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.UserEntity;

public class UserEntityConverter {

    public static UserEntity toEntity(User model) {
        return new UserEntity()
                .setId(model.getId())
                .setFirstName(model.getFirstName())
                .setLastName(model.getLastName())
                .setPatronymic(model.getPatronymic())
                .setPhone(model.getPhone())
                .setAddress(model.getAddress())
                .setEmail(model.getEmail());
    }

    public static User toDomain(UserEntity entity) {
        return User.builder()
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
