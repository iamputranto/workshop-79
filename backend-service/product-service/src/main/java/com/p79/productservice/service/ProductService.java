package com.p79.productservice.service;

import com.p79.productservice.dto.ProductRequest;
import com.p79.productservice.model.Product;
import com.p79.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        return productRepository.save(newProduct);
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product getProduct(String id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            return product.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    public Product updateProduct(String id, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            Product updatedProduct = product.get();

            updatedProduct.setName(productRequest.getName());
            updatedProduct.setDescription(productRequest.getDescription());
            updatedProduct.setPrice(productRequest.getPrice());

            return productRepository.save(updatedProduct);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    public String deleteProduct(String id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
            return "Product deleted";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }


}

