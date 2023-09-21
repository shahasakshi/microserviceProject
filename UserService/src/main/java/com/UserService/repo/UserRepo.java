package com.UserService.repo;

import com.UserService.model.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<user,String> {

//    user findByname(String name);
user findByname(String name);
}

