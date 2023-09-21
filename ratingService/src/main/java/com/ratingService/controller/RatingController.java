package com.ratingService.controller;

import com.ratingService.model.Rating;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //save
    @PostMapping("/save")
    public Rating saveRating(@RequestBody Rating r)
    {
        return ratingService.saveRating(r);
    }

    //getAllRating
    @GetMapping("/getall")
    public List<Rating> getAllRating(){
        return ratingService.getAllRating();
    }

    //getByName

    @GetMapping("/getall/{name}")
    public Rating getByName(@PathVariable String name){


        return ratingService.getRatingByName(name);
    }
}
