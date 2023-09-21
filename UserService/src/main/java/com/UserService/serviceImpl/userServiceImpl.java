package com.UserService.serviceImpl;

import com.UserService.model.Product;
import com.UserService.model.Rating;
import com.UserService.model.user;
import com.UserService.repo.UserRepo;
import com.UserService.service.userService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(userServiceImpl.class);

    @Override
    public user saveUser(user u) {
        return userRepo.save(u);
    }

    @Override
    public List<user> getAllUser() {

        return userRepo.findAll();
    }

    @Override
    public user getByusername(String name) {
        user us= userRepo.findByname(name);

        //user->product->rating
        //get product by name
        //http://localhost:1001/get/snaxy
        Product[] productData=restTemplate.getForObject("http://localhost:1001/get/"+us.getName(),Product[].class);

        logger.info("{} ",productData);

        List<Product> productList= Arrays.stream(productData).collect(Collectors.toList());

        List<Product> pList= productList.stream().map(
                product ->
                {
                    //rating by name
                    //http://localhost:1003/getall/snaxy
                    ResponseEntity<Rating> ratingEntity= restTemplate.getForEntity("http://localhost:1003/getall/"+product.getName(),Rating.class);
                    Rating r= ratingEntity.getBody();
                    product.setRating(r);
                    return product;
                }).collect(Collectors.toList());

        //set product in user
        us.setProductList(pList);
        return us;
    }




}
