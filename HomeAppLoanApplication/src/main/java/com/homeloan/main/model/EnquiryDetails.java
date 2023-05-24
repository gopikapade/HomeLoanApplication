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
	private String firstName,lastName,email,marrtialStatus,pancardNo;
	private Integer age;
	private Double mobileNo,income,loanAmmount;
	private Boolean oeResponce;
	private Boolean userResponce;
	private Boolean cmResponce;
	private Boolean forwardToOe;
	private Integer tenure;
	@OneToOne(cascade = CascadeType.ALL)
	private EducationlInfo education;
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cibilEnquiry;
	
}
