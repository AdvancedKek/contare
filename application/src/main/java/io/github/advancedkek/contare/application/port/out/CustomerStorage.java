package io.github.advancedkek.contare.application.port.out;

import io.github.advancedkek.contare.domain.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerStorage {
    List<Customer> find(UUID id);
    List<Customer> get();
    Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(UUID id);
}
