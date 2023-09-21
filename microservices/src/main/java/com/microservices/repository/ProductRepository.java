package com.microservices.repository;

import com.microservices.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import  java.util.*;

public interface ProductRepository extends JpaRepository<Product,String> {

    List<Product> findByname(String name);

}
