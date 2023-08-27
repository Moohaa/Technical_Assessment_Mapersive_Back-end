package com.example.Insurance_API.controller;


import com.example.Insurance_API.services.CustomerService;
import com.example.Insurance_API.services.InsuranceService;
import com.example.Insurance_API.utils.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class InsuranceController {
    private final InsuranceService insuranceService;

    private  final CustomerService customerService;

    public InsuranceController(InsuranceService insuranceService, CustomerService customerService) {
        this.insuranceService = insuranceService;
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public CommonResponse getCustomers(@RequestParam("pageNumber") String pageNumber, @RequestParam("pageSize") String pageSize,@RequestParam(value = "customer_id",required = false) String customer_id) {
        return this.customerService.getCustomers(pageNumber,pageSize,customer_id);
    }
    @GetMapping("/insurances")
    public CommonResponse getInsurances( @RequestParam("customer_id") String customerId) {
       CommonResponse res=CommonResponse.generateResponse(CommonResponse.ResponseType.SUCCESS,"",
               this.insuranceService.getInsurances(Long.valueOf(customerId)));

        return res;
    }
    @GetMapping("/customers/{id}")
    public CommonResponse getCustomer( @PathVariable String id) {
        CommonResponse  res =CommonResponse.generateResponse(CommonResponse.ResponseType.SUCCESS,"",
                this.customerService.getCustomer(id));
        return res;
    }

    @GetMapping("/customersCounts")
    public CommonResponse getCustomersCount() {
        return CommonResponse.generateResponse(CommonResponse.ResponseType.SUCCESS,"",this.customerService.getCustomerCount());
    }


}
