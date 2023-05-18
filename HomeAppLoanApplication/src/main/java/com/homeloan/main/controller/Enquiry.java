package com.homeloan.main.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust_enquiry")
public class Enquiry {
    @Id
	private Integer enquiryId;
	
	
}
