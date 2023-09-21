package com.ratingService.repo;

import com.ratingService.model.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {

    Rating findByName(String name);
}
