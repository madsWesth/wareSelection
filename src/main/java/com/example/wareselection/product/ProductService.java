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

    public void delete(int id) {
        productRepository.delete(id);
    }

    public void update(int id) {
        productRepository.update(id);
    }

}
