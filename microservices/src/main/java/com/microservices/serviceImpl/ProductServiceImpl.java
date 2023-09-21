package com.microservices.serviceImpl;

import com.microservices.model.Product;
import com.microservices.repository.ProductRepository;
import com.microservices.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveMyProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String userId) {
        return productRepository.findById(userId);
    }

    @Override
    public List<Product> getByUserName(String name) {
        return productRepository.findByname(name);
    }
}
