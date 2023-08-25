package com.example.Insurance_API.model.dto;

import com.example.Insurance_API.model.Customer;
import com.example.Insurance_API.model.Insurance;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class JsonData {

    @JsonProperty("Policy_id")
    private  Long policyId;

    @JsonProperty("Date_of_Purchase")
    private String date;

    @JsonProperty("Customer_id")
    private Long customerId;

    @JsonProperty("Fuel")
    private String fuelType;


    @JsonProperty("VEHICLE_SEGMENT")
    private  String vehicleSegment;

    @JsonProperty("Premium")
    private int premium;
    private int bodily_injury_liability;
    private int personal_injury_protection;
    private int property_damage_liability;
    private int collision;
    private int comprehensive;

    @JsonProperty("Customer_Gender")
    private String customerGender;

    @JsonProperty("Customer_Income_group")
    private String customer_Income_group;
    @JsonProperty("Customer_Region")
    private String customer_Region;
    @JsonProperty("Customer_Marital_status")
    private int customer_Marital_status;


    public Insurance toInsurance(){
        Insurance insurance=new Insurance();

        insurance.setPolicyId(this.policyId);
        insurance.setCustomerId(this.customerId);
        insurance.setCollision(this.collision);
        insurance.setComprehensive(this.comprehensive);
        insurance.setBodily_injury_liability(this.bodily_injury_liability);
        insurance.setPersonal_injury_protection(this.personal_injury_protection);
        insurance.setPremium(this.premium);
        insurance.setProperty_damage_liability(this.property_damage_liability);
        insurance.setDate(this.date);
        insurance.setFuelType(this.fuelType);
        insurance.setVehicleSegment(this.vehicleSegment);
        return insurance;
    }

    public Customer  toCustomer(){

        Customer customer =new Customer();

        customer.setCustomerId(this.customerId.toString());
        customer.setCustomer_Region(this.customer_Region);
        customer.setCustomer_Income_group(this.customer_Income_group);
        customer.setCustomerGender(this.customerGender);
        customer.setCustomer_Marital_status(this.customer_Marital_status);


        return  customer;
    }



}
