package com.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private String address;

    @Transient
   CustomerLocker customerLocker;

}
