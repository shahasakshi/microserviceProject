package com.UserService.controller;

import com.UserService.model.user;
import com.UserService.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private userService us;

    //save
    @PostMapping("/save")
    public user saveUser(@RequestBody user u)
    {
        return us.saveUser(u);

    }

    //get all
    @GetMapping("/getall")
    public List<user> getAllUser()
    {
        return us.getAllUser();
    }

    //get by name
    @GetMapping("/getbyname/{name}")
    public user getByName(@PathVariable String name)
    {
        return us.getByusername(name);
    }

}
