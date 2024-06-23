package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.CustomerStorage;
import io.github.advancedkek.contare.domain.Customer;
import io.github.advancedkek.contare.domain.exception.CustomerNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.CustomerEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudCustomerUseCaseImpl implements CustomerStorage {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> find(UUID id) {
        return customerRepository.findById(id)
                .map(CustomerEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<Customer> get() {
        return customerRepository.findAll().stream()
                .map(CustomerEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Customer create(Customer customer) {
        var newEntity = customerRepository.save(CustomerEntityConverter.toEntity(customer));
        return CustomerEntityConverter.toDomain(newEntity);
    }

    @Override
    public Customer update(Customer customer) {
        var isCustomerExist = customerRepository.existsById(customer.getId());
        if (!isCustomerExist) {
            var message = String.format("Customer with ID %s not found", customer.getId());
            throw new CustomerNotFoundException(message);
        }
        customerRepository.save(CustomerEntityConverter.toEntity(customer));
        return customer;
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}