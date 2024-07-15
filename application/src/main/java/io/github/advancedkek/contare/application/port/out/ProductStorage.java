package io.github.advancedkek.contare.application.port.out;

import io.github.advancedkek.contare.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductStorage {
    List<Product> find (UUID id);
    List<Product> get();
    Product create(Product product);
    Product update(Product product);
    void delete(UUID id);
}
