
package com.UserService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    private String userId;
    private String name;
    private String description;
    private long price;
    private Rating rating;



}

