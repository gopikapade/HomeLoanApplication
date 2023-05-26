package com.homeloan.main.retalitionalmodel;

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
public class PreviousLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer previousLoanId;
	private Double previousLoanAmount,
    previousLoanpaidAmount, previousLoanremainingAmount;
	private Integer previousLoanTenure, previousLoandeafulterCount;
	private String previousLoanStatus,
	previousLoanRemark;
}
