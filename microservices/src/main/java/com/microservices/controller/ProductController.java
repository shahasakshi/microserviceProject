package com.microservices.controller;


import com.microservices.model.Product;
import com.microservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

   @Autowired
    private ProductService productService;

   //save
    @PostMapping("/save")
    Product saveData(@RequestBody Product product)
    {
        return productService.saveMyProduct(product);
    }

    //get all
    @GetMapping("/getall")
    public  List<Product> getAll()
    {
        return  productService.getAllProduct();
    }

    //get by name
    @GetMapping("/get/{name}")
    public List<Product> getByname(@PathVariable String name)
    {
        return  productService.getByUserName(name);
    }
}
