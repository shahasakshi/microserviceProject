package com.custemorlocker.service;

import com.custemorlocker.model.CustomerLocker;

import java.util.List;

public interface LockerService {

    //create
    CustomerLocker saveInfo(CustomerLocker customerLocker);

    //getAll
    List<CustomerLocker> getAllLocker();

    //getByLockerId
    CustomerLocker getById(String LId);

    CustomerLocker getByCustomerId(String customerId);


}
