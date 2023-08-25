package com.example.Insurance_API.services;


import com.example.Insurance_API.model.Insurance;
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

    public DbPopulationService(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Start populating the db");

        ObjectMapper objectMapper = new ObjectMapper();
        List<Insurance> items = objectMapper.readValue(new File("src/main/resources/JsonData/Insurance-Data.json"), new TypeReference<>() {
        });

        items.stream().forEach(insurance->{
            this.insuranceService.addInsuranceRecord(insurance);
        });
        log.info("End populating the db");
    }
}
