package com.example.Insurance_API.repository;

import com.example.Insurance_API.model.Insurance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Long>, PagingAndSortingRepository<Insurance,Long> {

    Page<Insurance> findAll(Pageable pageable);
}
