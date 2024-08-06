package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateUserRequest;
import io.github.advancedkek.contare.api.model.User;
import io.github.advancedkek.contare.api.model.UpdateUserRequest;

public class UserApiConverter {

    public static User toApi(io.github.advancedkek.contare.domain.User model) {
        return new User()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .patronymic(model.getPatronymic())
                .phone(model.getPhone())
                .address(model.getAddress())
                .email(model.getEmail());
    }

    public static io.github.advancedkek.contare.domain.User toDomain(CreateUserRequest request) {
        return io.github.advancedkek.contare.domain.User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }

    public static io.github.advancedkek.contare.domain.User toDomain(UpdateUserRequest request) {
        return io.github.advancedkek.contare.domain.User.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }
}
