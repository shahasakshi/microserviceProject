package com.microservices.service;

import com.microservices.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;



public interface ProductService {

    //save product
    Product saveMyProduct(Product product);

    //get all product
    List<Product> getAllProduct();

    //get by id
    Optional<Product> getProductById(String userId);

    //get by name
    List<Product> getByUserName(String name);


}
