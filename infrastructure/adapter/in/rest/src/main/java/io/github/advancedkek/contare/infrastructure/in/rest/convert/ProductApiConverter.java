package io.github.advancedkek.contare.infrastructure.in.rest.convert;

import io.github.advancedkek.contare.api.model.CreateProductRequest;
import io.github.advancedkek.contare.api.model.Product;
import io.github.advancedkek.contare.api.model.UpdateProductRequest;

public class ProductApiConverter {

    public static Product toApi(io.github.advancedkek.contare.domain.Product model) {
        return new Product()
                .id(model.getId())
                .name(model.getName())
                .description(model.getDescription())
                .price(model.getPrice());
    }

    public static io.github.advancedkek.contare.domain.Product toDomain(CreateProductRequest request) {
        return io.github.advancedkek.contare.domain.Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    public static io.github.advancedkek.contare.domain.Product toDomain(UpdateProductRequest request) {
        return io.github.advancedkek.contare.domain.Product.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }
}
