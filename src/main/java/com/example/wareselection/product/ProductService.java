package com.example.wareselection.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Products> fetchAll() {
        return productRepository.findAll();
    }

    public Optional<Products> findById(int id) {
        return productRepository.findById(id);
    }

    public void create(Products product) {
        productRepository.save(product);
    }

    public void update(int id, Products product) {
        product.setId(id);
        productRepository.save(product);
    }

    public void delete(int id) {
        Optional<Products> product = productRepository.findById(id);
        product.ifPresent(value -> productRepository.delete(value));
    }

}
