package com.example.Insurance_API.services;

import com.example.Insurance_API.model.Customer;
import com.example.Insurance_API.repository.CustomerRepository;
import com.example.Insurance_API.utils.CommonResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final InsuranceService insuranceService;

    public CustomerService(CustomerRepository customerRepository, InsuranceService insuranceService) {
        this.customerRepository = customerRepository;
        this.insuranceService = insuranceService;
    }

    public void addCustomerRecord(Customer customer){
        this.customerRepository.save(customer);
    }


    public CommonResponse getCustomers(String pageNumber, String pageSize,String customer_id){

        CommonResponse res=null;
        Pageable page = PageRequest.of(Integer.valueOf(pageNumber), Integer.valueOf(pageSize));

        List<Customer> customers=null;
        if(customer_id!="") customers=this.customerRepository.findByCustomerStartWithSub(customer_id,page).getContent();
        else customers=this.customerRepository.findAll(page).getContent();

        customers.stream().forEach((c)->{
            String customerPolicies = String.join(",",this.insuranceService.getInsurances(Long.valueOf(c.getCustomerId())).stream().map((e-> e.getPolicyId().toString())).collect(Collectors.toList()));

            c.setPolicies(customerPolicies);
        });


        res=CommonResponse.generateResponse(CommonResponse.ResponseType.SUCCESS,"",customers);

        return  res;
    }

    public Customer getCustomer(String customerId){
        return  this.customerRepository.findByCustomerId(customerId);
    }


    public Long getCustomerCount(){
        return  this.customerRepository.count();
    }

}
