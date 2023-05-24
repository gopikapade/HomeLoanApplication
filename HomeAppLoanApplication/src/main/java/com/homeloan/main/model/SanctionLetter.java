package com.homeloan.main.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SanctionLetter {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer sanctionId;
private String sanctionDate,
applicantName,producthomeEquity,
modeOfPayment,
remarks,
termsCondition,
status;
private Integer rateOfInterest,
loanTenure;
private Long contactno;
private Double monthlyEmiAmount,loanammount;

}
