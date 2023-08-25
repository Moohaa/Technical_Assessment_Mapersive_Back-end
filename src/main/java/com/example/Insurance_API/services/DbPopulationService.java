package com.example.Insurance_API.services;


import com.example.Insurance_API.model.dto.JsonData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class DbPopulationService implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DbPopulationService.class);
    private final InsuranceService insuranceService;
    private final CustomerService customerService;

    public DbPopulationService(InsuranceService insuranceService, CustomerService customerService) {
        this.insuranceService = insuranceService;
        this.customerService = customerService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start populating the db");

        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonData> items = objectMapper.readValue(new File("src/main/resources/JsonData/Insurance-Data.json"), new TypeReference<>() {
        });

        items.stream().forEach(item->{
            this.insuranceService.addInsuranceRecord(item.toInsurance());
            this.customerService.addCustomerRecord(item.toCustomer());

        });
        log.info("End populating the db");
    }
}
