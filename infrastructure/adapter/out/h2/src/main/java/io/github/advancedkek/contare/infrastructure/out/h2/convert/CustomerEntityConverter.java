package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.Customer;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.CustomerEntity;

public class CustomerEntityConverter {

    public static CustomerEntity toEntity(Customer model) {
       return new CustomerEntity()
               .setId(model.getId())
               .setFirstName(model.getFirstName())
               .setLastName(model.getLastName())
               .setPatronymic(model.getPatronymic())
               .setPhone(model.getPhone())
               .setAddress(model.getAddress())
               .setEmail(model.getEmail());
    }

    public static Customer toDomain(CustomerEntity entity) {
        return Customer.builder()
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
