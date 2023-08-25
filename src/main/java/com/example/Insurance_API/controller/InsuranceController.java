package com.example.Insurance_API.controller;


import com.example.Insurance_API.services.InsuranceService;
import com.example.Insurance_API.utils.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/insurances")
    public CommonResponse getInsurances(@RequestParam("pageNumber") String pageNumber, @RequestParam("pageSize") String pageSize) {

        return this.insuranceService.getInsurances(pageNumber,pageSize);
    }
    @GetMapping("/insurances/{id}")
    public CommonResponse getInsurance(@PathVariable String id) {

        return null;
    }


}
