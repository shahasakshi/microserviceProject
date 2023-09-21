package com.UserService.service;

import com.UserService.model.user;

import java.util.List;

public interface userService {

    //save
    user saveUser(user u);

    //get all
    List<user> getAllUser();

    //get by name
    user getByusername(String name);
}
