package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.CustomerApiDelegate;
import io.github.advancedkek.contare.api.model.CreateCustomerRequest;
import io.github.advancedkek.contare.api.model.CustomerResponse;
import io.github.advancedkek.contare.api.model.CustomersResponse;
import io.github.advancedkek.contare.api.model.UpdateCustomerRequest;
import io.github.advancedkek.contare.application.port.in.CrudCustomerUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.CustomerApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerApiDelegateImpl implements CustomerApiDelegate {

    private final CrudCustomerUseCase customerUseCase;

    @Override
    public ResponseEntity<CustomerResponse> addCustomer(CreateCustomerRequest createCustomerRequest) {
        var customer = customerUseCase.create(CustomerApiConverter.toDomain(createCustomerRequest));
        return ResponseEntity.ok(
                new CustomerResponse(
                        CustomerApiConverter.toApi(customer)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(UUID id) {
        customerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CustomersResponse> getCustomerById(UUID id) {
        var customers = Optional.ofNullable(id)
                .map(customerUseCase::getById)
                .orElse(customerUseCase.get());
        var customersResponse = new CustomersResponse(customers.stream()
                .map(CustomerApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(customersResponse);
    }

    @Override
    public ResponseEntity<CustomerResponse> updateCustomer(UpdateCustomerRequest updateCustomerRequest) {
        var customer = customerUseCase.update(CustomerApiConverter.toDomain(updateCustomerRequest));
        return ResponseEntity.ok(
                new CustomerResponse(
                        CustomerApiConverter.toApi(customer)
                )
        );
    }
}