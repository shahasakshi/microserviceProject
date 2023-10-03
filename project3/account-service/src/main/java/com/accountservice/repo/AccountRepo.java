package com.accountservice.repo;

import com.accountservice.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends MongoRepository<Account,String> {
    List<Account> findByCustomerId(String customerId);
}
