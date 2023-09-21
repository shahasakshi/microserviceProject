package com.ratingService.service;

import com.ratingService.model.Rating;

import java.util.List;

public interface RatingService {
    //save
  Rating saveRating(Rating r);

    //getRating
    List<Rating> getAllRating();

    Rating getRatingByName(String name);

}
