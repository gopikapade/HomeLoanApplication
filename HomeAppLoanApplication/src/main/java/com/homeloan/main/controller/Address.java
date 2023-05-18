package com.homeloan.main.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cust_enquiry")
@Data
public class Address {
    @Id
	private Integer enquiryId;
    private String fullName;
	
	
}
