package com.custemorlocker.service;

import com.custemorlocker.model.CustomerLocker;
import com.custemorlocker.repo.LockerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerServiceImpl implements LockerService {

    @Autowired
    private LockerRepo lockerRepo;

    @Override
    public CustomerLocker saveInfo(CustomerLocker customerLocker) {
        return lockerRepo.save(customerLocker);
    }

    @Override
    public List<CustomerLocker> getAllLocker() {
        return lockerRepo.findAll();
    }

    @Override
    public CustomerLocker getById(String LId) {
        return lockerRepo.findById(LId).get();
    }

    @Override
    public CustomerLocker getByCustomerId(String customerId) {
        return lockerRepo.findByCustomerId(customerId);
    }


}
