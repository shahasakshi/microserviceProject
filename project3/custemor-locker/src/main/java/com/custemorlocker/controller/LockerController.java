package com.custemorlocker.controller;

import com.custemorlocker.model.CustomerLocker;
import com.custemorlocker.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/locker")
public class LockerController {

    @Autowired
    private LockerService lockerService;

    //save
    @PostMapping("/save")
    private CustomerLocker save(@RequestBody CustomerLocker customerLocker)
    {
        String lockerId = UUID.randomUUID().toString();
        customerLocker.setLId(lockerId);
        return lockerService.saveInfo(customerLocker);
    }

    //getall
    @GetMapping("/getAll")
    private List<CustomerLocker> getAll(){
        return lockerService.getAllLocker();
    }

    @GetMapping("/{LId}")
    private CustomerLocker getByLId(@PathVariable String LId){
        return lockerService.getById(LId);
    }
    @GetMapping("/customer/{customerId}")
    private CustomerLocker getByCuId(@PathVariable String customerId){
        return lockerService.getByCustomerId(customerId);
    }


}
