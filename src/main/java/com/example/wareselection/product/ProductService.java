package com.example.wareselection.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> fetchAll() {
        return productRepository.fetchAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    public void create(Product product) {
        productRepository.create(product);
    }

    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    public void delete(int id) {
        productRepository.delete(id);
    }

}
