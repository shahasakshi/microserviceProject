package com.custemorlocker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Locker")
public class CustomerLocker {

    @Id
    private String LId;
    private String customerId;
    private Boolean nominee;

}
