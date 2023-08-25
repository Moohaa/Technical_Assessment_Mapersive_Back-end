package com.example.Insurance_API.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "Insurance")
@Getter
@Setter
@ToString
public class Insurance {

    @Id
    @Column(name = "Policy_id")
    @JsonProperty("Policy_id")
    private  Long policyId;

    @Column(name = "Date_of_Purchase")
    @JsonProperty("Date_of_Purchase")
    private String date;

    @Column(name = "Customer_id")
    @JsonProperty("Customer_id")
    private Long customerId;

    @Column(name = "Fuel")
    @JsonProperty("Fuel")
    private String fuelType;


    @Column(name = "VEHICLE_SEGMENT")
    @JsonProperty("VEHICLE_SEGMENT")
    private  String vehicleSegment;

    @Column(name="Premium")
    @JsonProperty("Premium")
    private int premium;
    private int bodily_injury_liability;
    private int personal_injury_protection;
    private int property_damage_liability;
    private int collision;
    private int comprehensive;





}
