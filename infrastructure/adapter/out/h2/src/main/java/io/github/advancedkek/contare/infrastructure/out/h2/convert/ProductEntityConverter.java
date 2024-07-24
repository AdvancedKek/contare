package io.github.advancedkek.contare.infrastructure.out.h2.convert;

import io.github.advancedkek.contare.domain.Product;
import io.github.advancedkek.contare.infrastructure.out.h2.domain.ProductEntity;

public class ProductEntityConverter {

    public static ProductEntity toEntity(Product model) {
        return new ProductEntity()
                .setId(model.getId())
                .setName(model.getName())
                .setDescription(model.getDescription())
                .setPrice(model.getPrice());
    }

    public static Product toDomain(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }
}
