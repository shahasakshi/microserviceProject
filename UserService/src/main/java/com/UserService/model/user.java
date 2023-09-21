package com.UserService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "UserService")
public class user {

    @Id
    private String uId;
    private String name;
    private String email;

    private List<Product> productList=new ArrayList<>();
}
