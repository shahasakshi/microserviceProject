package com.ratingService.serviceImpl;

import com.ratingService.model.Rating;
import com.ratingService.repo.RatingRepo;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating saveRating(Rating r) {
       return ratingRepo.save(r);
    }

    @Override
    public List<Rating> getAllRating() {
       return ratingRepo.findAll();
    }

    @Override
    public Rating getRatingByName(String name) {

        return ratingRepo.findByName(name);
    }
}
