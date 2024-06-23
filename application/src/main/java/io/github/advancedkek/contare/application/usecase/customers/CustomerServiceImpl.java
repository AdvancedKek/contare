package io.github.advancedkek.contare.application.usecase.customers;

import io.github.advancedkek.contare.application.port.in.CrudCustomerUseCase;
import io.github.advancedkek.contare.application.port.out.CustomerStorage;
import io.github.advancedkek.contare.domain.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CrudCustomerUseCase {

    private final CustomerStorage customerStorage;

    @Override
    public List<Customer> getById(UUID id) {
        return customerStorage.find(id);
    }

    @Override
    public List<Customer> get() {
        return customerStorage.get();
    }

    @Override
    public Customer create(Customer customer) {
        return customerStorage.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerStorage.update(customer);
    }

    @Override
    public void delete(UUID id) {
        customerStorage.delete(id);
    }
}
