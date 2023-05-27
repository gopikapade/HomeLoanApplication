package com.homeloan.main.retalitionalmodel;




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
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CurrentLoanDetails{
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer	currentloanId;
private Integer currentloanNo,
tenure;
private Double totalAmounttobepaid,rateOfInterest,totalInterest;
private String sanctionDate,remark,status;
@OneToOne(cascade = CascadeType.ALL)
//private EMIDetails emidetails;
private EMIDetails emidetails;

}
