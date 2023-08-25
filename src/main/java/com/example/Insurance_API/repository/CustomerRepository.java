package com.example.Insurance_API.repository;

import com.example.Insurance_API.model.Customer;
import com.example.Insurance_API.model.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String>, PagingAndSortingRepository<Customer,String> {
    Page<Customer> findAll(Pageable pageable);

    @Query("SELECT e FROM Customer e WHERE e.customerId LIKE :substring%")
    Page<Customer> findByCustomerStartWithSub(String substring,Pageable pageable);

    Customer findByCustomerId(String customerId);
    long count();
}
