package com.custemorlocker.repo;

import com.custemorlocker.model.CustomerLocker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockerRepo extends JpaRepository<CustomerLocker,String> {

    CustomerLocker findByCustomerId(String customerId);
}
