package com.customerservice.controller;

import com.customerservice.model.Customer;
import com.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    //create
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer)
    {
        String userId = UUID.randomUUID().toString();
        customer.setCustomerId(userId);
        return customerService.createCustomer(customer);
    }

    //getAll
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAll(){
        return  customerService.getAllCutomer();
    }

    //getById
    @GetMapping("id/{customerId}")
    public Customer getByCustomerId(@PathVariable String customerId){
        return customerService.getByCuId(customerId);
    }

    //update
    @PutMapping("update/{customerId}")
    public Customer updateById(@PathVariable String customerId,@RequestBody Customer customer){
        return customerService.updateCustomer(customerId,customer);
    }

    //delete
    @DeleteMapping("delete/{customerId}")
    public String delete(String customerId){
        customerService.deleteCustomer(customerId);
        return "deleted successfully";
    }


}
