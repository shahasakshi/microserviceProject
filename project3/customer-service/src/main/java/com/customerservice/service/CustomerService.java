package com.customerservice.service;

import com.customerservice.model.Customer;

import java.util.List;

public interface CustomerService {

    //create
    Customer createCustomer(Customer customer);

    //getAll

    List<Customer> getAllCutomer();

    //getByCustomerId
    Customer getByCuId(String customerId);

    //update

    Customer updateCustomer(String id,Customer customer);

    //delete
    String  deleteCustomer(String customerId);

   //get by accountId




}
