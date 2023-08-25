package com.example.Insurance_API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Customers")
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @JsonProperty("Customer_id")
    public String  customerId;
    @Column(name="Customer_Marital_status")
    @JsonProperty("Customer_Marital_status")
    private int customer_Marital_status;

    @Column(name="Customer_Gender")
    @JsonProperty("Customer_Gender")
    private String customerGender;

    @Column(name="Customer_Income_group")
    @JsonProperty("Customer_Income_group")
    private String customer_Income_group;
    @Column(name="Customer_Region")
    @JsonProperty("Customer_Region")
    private String customer_Region;

    private  String policies;

}
