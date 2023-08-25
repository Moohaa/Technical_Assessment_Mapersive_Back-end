package com.example.Insurance_API.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private  Long id;

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

    @Column(name="Customer_Gender")
    @JsonProperty("Customer_Gender")
    private String customerGender;

    @Column(name="Customer_Income_group")
    @JsonProperty("Customer_Income_group")
    private String customer_Income_group;
    @Column(name="Customer_Region")
    @JsonProperty("Customer_Region")
    private String customer_Region;
    @Column(name="Customer_Marital_status")
    @JsonProperty("Customer_Marital_status")
    private int customer_Marital_status;

}
