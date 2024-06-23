package io.github.advancedkek.contare.application.port.in;

import io.github.advancedkek.contare.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CrudCustomerUseCase {
    List<Customer> getById(UUID id);
    List<Customer> get();
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(UUID id);
}
