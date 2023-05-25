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
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ledgerId;
	private String ledgerCreatedDate,
	amountPaidtillDate,
	nextEmiDatestart,
	nextEmiDateEnd,
	previousEmitStatus,
	currentMonthEmiStatus,
	loanEndDate,
	loanStatus;
	private Double totalLoanAmount,
	payableAmountwithInterest,
	monthlyEMI,
	remainingAmount;
	private Integer tenure,	
	defaulterCount;

}
