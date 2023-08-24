package com.example.Insurance_API.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Insurance")
public class Insurance {

    @Id
    @Column(name = "Policy_id")
    private  Long id;

    @Column(name = "Date_of_Purchase")
    private Date date;

    @Column(name = "Customer_id")
    private Long customerId;

    @Column(name = "Fuel")
    private Long fuelType;


    @Column(name = "VEHICLE_SEGMENT")
    private  String vehicleSegment;

    @Column(name="Premium")
    private int premium;
    private int bodily_injury_liability;
    private int personal_injury_protection;
    private int property_damage_liability;
    private int collision;
    private int comprehensive;

    @Column(name="Customer_Gender")
    private String customerGender;

    @Column(name="Customer_Income_group")
    private String customer_Income_group;
    @Column(name="Customer_Region")
    private String customer_Region;
    @Column(name="Customer_Marital_status")
    private int customer_Marital_status;






    private void setId(Long id) {
        this.id = id;
    }

    private Long getId() {
        return id;
    }
}
