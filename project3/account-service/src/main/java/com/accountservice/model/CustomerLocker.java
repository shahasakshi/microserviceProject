package com.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLocker {

    @Id
    private String LId;
    private String customerId;
    private Boolean nominee;
}
