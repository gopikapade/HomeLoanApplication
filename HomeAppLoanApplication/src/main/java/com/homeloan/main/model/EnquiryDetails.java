package com.homeloan.main.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class EnquiryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enquryId;
	private String firstName,lastName,email,marrtialStatus;
	private Integer age;
	private Double mobileNo,pancardNo,income,loanAmmount;
	@OneToOne(cascade = CascadeType.ALL)
	private EducationlInfo education;

	

}
