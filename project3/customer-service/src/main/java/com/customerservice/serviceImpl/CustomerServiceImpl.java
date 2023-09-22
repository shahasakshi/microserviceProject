package com.customerservice.serviceImpl;

import com.customerservice.model.Customer;
import com.customerservice.model.CustomerLocker;
import com.customerservice.repo.CustomerRepo;
import com.customerservice.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> getAllCutomer() {
        return customerRepo.findAll();
    }

    @Override
    public Customer getByCuId(String customerId) {
        //get by custemore from customer service
        Customer c = customerRepo.findById(customerId).get();

        //http://localhost:1100/locker/customer/
        CustomerLocker customerLocker = restTemplate.getForObject("http://localhost:1100/locker/customer/"+customerId, CustomerLocker.class);
        c.setCustomerLocker(customerLocker);

        logger.info("{}",c);
        return c;
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow(() ->new IllegalArgumentException( "customer of given id not found"));
        customer1.setName(customer.getName());
        customer1.setPhone(customer.getPhone());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        //after save in custemer1

        return customerRepo.save(customer1);
    }

    @Override
    public String deleteCustomer(String customerId) {
         customerRepo.deleteById(customerId);
         return  "deleted successfully";
    }


}
