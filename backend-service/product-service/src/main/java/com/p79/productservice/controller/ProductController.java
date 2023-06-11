package com.p79.productservice.controller;

import com.p79.productservice.dto.ProductRequest;
import com.p79.productservice.model.Product;
import com.p79.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable("id") String id) {
        return productService.getProduct(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable("id") String id, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable("id") String id) {
        return productService.deleteProduct(id);
    }


}