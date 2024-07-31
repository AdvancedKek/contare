package io.github.advancedkek.contare.infrastructure.out.h2;

import io.github.advancedkek.contare.application.port.out.ProductStorage;
import io.github.advancedkek.contare.domain.Product;
import io.github.advancedkek.contare.domain.exception.ProductNotFoundException;
import io.github.advancedkek.contare.infrastructure.out.h2.convert.ProductEntityConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CrudProductUseCaseImpl implements ProductStorage {

    private final ProductRepository productRepository;

    @Override
    public List<Product> find(UUID id) {
        return productRepository.findById(id)
                .map(ProductEntityConverter::toDomain)
                .stream().toList();
    }

    @Override
    public List<Product> get() {
        return productRepository.findAll().stream()
                .map(ProductEntityConverter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Product create(Product product) {
        var newEntity = productRepository.save(ProductEntityConverter.toEntity(product));
        return ProductEntityConverter.toDomain(newEntity);
    }

    @Override
    public Product update(Product product) {
        var isProductExist = productRepository.existsById(product.getId());
        if (!isProductExist) {
            var message = String.format("Product with ID %s not found", product.getId());
            throw new ProductNotFoundException(message);
        }
        productRepository.save(ProductEntityConverter.toEntity(product));
        return product;
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }
}