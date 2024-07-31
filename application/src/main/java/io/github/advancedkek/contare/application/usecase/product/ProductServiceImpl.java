package io.github.advancedkek.contare.application.usecase.product;

import io.github.advancedkek.contare.application.port.in.CrudProductUseCase;
import io.github.advancedkek.contare.application.port.out.ProductStorage;
import io.github.advancedkek.contare.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements CrudProductUseCase {

    private final ProductStorage productStorage;

    @Override
    public List<Product> getById(UUID id) {
        return productStorage.find(id);
    }

    @Override
    public List<Product> get() {
        return productStorage.get();
    }

    @Override
    public Product create(Product product) {
        return productStorage.create(product);
    }

    @Override
    public Product update(Product product) {
        return productStorage.update(product);
    }

    @Override
    public void delete(UUID id) {
        productStorage.delete(id);
    }
}
