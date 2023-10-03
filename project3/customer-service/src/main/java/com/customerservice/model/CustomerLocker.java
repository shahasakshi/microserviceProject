package com.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLocker {

    @Id
    private String LId;
    private String customerId;
    private Boolean nominee;

}
