package com.example.Insurance_API.services;


import com.example.Insurance_API.model.Insurance;
import com.example.Insurance_API.repository.InsuranceRepository;
import com.example.Insurance_API.utils.CommonResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }
    public List<Insurance> getInsurances(Long customerId) {
        List<Insurance> insurances= this.insuranceRepository.findAllByCustomerId(customerId);
        return  insurances;
    }
    public void addInsuranceRecord(Insurance insurance){
        this.insuranceRepository.save(insurance);
    }


}
