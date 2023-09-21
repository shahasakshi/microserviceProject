package com.microservices.model;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor

@Table(name = "Product")
@Entity
public class Product {
    @Id

    private String userId;
    private String name;
    private String description;
    private long price;

    public Product(String userId, String name, String description, long price) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


}
