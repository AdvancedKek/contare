package io.github.advancedkek.contare.infrastructure.in.rest;

import io.github.advancedkek.contare.api.ProductApiDelegate;
import io.github.advancedkek.contare.api.model.CreateProductRequest;
import io.github.advancedkek.contare.api.model.ProductResponse;
import io.github.advancedkek.contare.api.model.ProductsResponse;
import io.github.advancedkek.contare.api.model.UpdateProductRequest;
import io.github.advancedkek.contare.application.port.in.CrudProductUseCase;
import io.github.advancedkek.contare.infrastructure.in.rest.convert.ProductApiConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductApiDelegateImpl implements ProductApiDelegate {

    private final CrudProductUseCase customerUseCase;

    @Override
    public ResponseEntity<ProductResponse> addProduct(CreateProductRequest createProductRequest) {
        var customer = customerUseCase.create(ProductApiConverter.toDomain(createProductRequest));
        return ResponseEntity.ok(
                new ProductResponse(
                        ProductApiConverter.toApi(customer)
                )
        );
    }

    @Override
    public ResponseEntity<Void> deleteProduct(UUID id) {
        customerUseCase.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductsResponse> getProductById(UUID id) {
        var customers = Optional.ofNullable(id)
                .map(customerUseCase::getById)
                .orElse(customerUseCase.get());
        var customersResponse = new ProductsResponse(customers.stream()
                .map(ProductApiConverter::toApi)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(customersResponse);
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(UpdateProductRequest updateProductRequest) {
        var customer = customerUseCase.update(ProductApiConverter.toDomain(updateProductRequest));
        return ResponseEntity.ok(
                new ProductResponse(
                        ProductApiConverter.toApi(customer)
                )
        );
    }
}