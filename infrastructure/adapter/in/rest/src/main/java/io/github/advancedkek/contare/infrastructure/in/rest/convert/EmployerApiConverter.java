package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateEmployerRequest;
import io.github.advancedkek.contare.api.model.Employer;
import io.github.advancedkek.contare.api.model.UpdateEmployerRequest;

public class EmployerApiConverter {

    public static Employer toApi(io.github.advancedkek.contare.domain.Employer model) {
        return new Employer()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .patronymic(model.getPatronymic())
                .phone(model.getPhone())
                .address(model.getAddress())
                .email(model.getEmail());
    }

    public static io.github.advancedkek.contare.domain.Employer toDomain(CreateEmployerRequest request) {
        return io.github.advancedkek.contare.domain.Employer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }

    public static io.github.advancedkek.contare.domain.Employer toDomain(UpdateEmployerRequest request) {
        return io.github.advancedkek.contare.domain.Employer.builder()
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
