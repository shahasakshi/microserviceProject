package com.ratingService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "RatingSevice")
public class Rating {

    @Id
    private String rId;
    private String name;
    private int rating;

    public Rating(String rId, String name, int rating) {
        this.rId = rId;
        this.name = name;
        this.rating = rating;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rId='" + rId + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
