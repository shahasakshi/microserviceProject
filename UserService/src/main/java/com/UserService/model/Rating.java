package com.UserService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {

    @Id
    private String rId;
    private String name;
    private int rating;
}
