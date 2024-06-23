package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateCustomerRequest;
import io.github.advancedkek.contare.api.model.Customer;
import io.github.advancedkek.contare.api.model.UpdateCustomerRequest;

public class CustomerApiConverter {

    public static Customer toApi(io.github.advancedkek.contare.domain.Customer model) {
        return new Customer()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .patronymic(model.getPatronymic())
                .phone(model.getPhone())
                .address(model.getAddress())
                .email(model.getEmail());
    }

    public static io.github.advancedkek.contare.domain.Customer toDomain(CreateCustomerRequest request) {
        return io.github.advancedkek.contare.domain.Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .phone(request.getPhone())
                .address(request.getAddress())
                .email(request.getEmail())
                .build();
    }

    public static io.github.advancedkek.contare.domain.Customer toDomain(UpdateCustomerRequest request) {
        return io.github.advancedkek.contare.domain.Customer.builder()
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
