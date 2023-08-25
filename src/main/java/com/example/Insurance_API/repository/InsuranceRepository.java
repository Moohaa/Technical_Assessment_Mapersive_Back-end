package com.example.Insurance_API.repository;

import com.example.Insurance_API.model.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InsuranceRepository extends CrudRepository<Insurance, Long>, PagingAndSortingRepository<Insurance,Long> {

    Page<Insurance> findAll(Pageable pageable);
    List<Insurance>  findAllByPolicyIdAndCustomerId(Long policyId,Long customerId);
    List<Insurance>  findAllByCustomerId(Long policy_id);


    long count();
}
