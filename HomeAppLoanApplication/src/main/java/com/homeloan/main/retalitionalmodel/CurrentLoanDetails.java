package com.homeloan.main.retalitionalmodel;




import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
private Double
totalAmounttobepaid
,rateOfInterest
,totalInterest;
private String sanctionDate,remark,status;
@OneToMany(cascade = CascadeType.ALL)
//private EMIDetails emidetails;
private List<EMIDetails> emiDetails;

}
