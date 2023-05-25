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
public class LoanDisbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loanDisbursementid;
	private Integer loanNo;
	private String agreementDate, amountPayType,
			bankName,
			ifsc, accountType,
			paymentStatus, amountPaidDate;
	private Double totalAmount,	transferAmount;	
	private Long accountNumber;

}
