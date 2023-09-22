package com.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private String address;





}
