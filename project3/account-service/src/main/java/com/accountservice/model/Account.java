package com.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "AccountService")
public class Account {

    @Id
    private String accountId;
    private String accountType;
    private int balance;
    private String customerId;

    @DateTimeFormat
    Date accountOpeningDate;

    @DateTimeFormat
    Date lastActivity;

    @Transient
    Customer customer;

    @Transient
    CustomerLocker customerLocker;

    // Constructor or method where you set the dates
//    public Account() {
//        // Set accountOpeningDate to a specific date
//        accountOpeningDate = new Date(); // This sets it to the current date and time
//
//        // Set lastActivity to a different date
//        lastActivity = new Date(System.); // This sets it to one day ago
//
//
//    }

}
