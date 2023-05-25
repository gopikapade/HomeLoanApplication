package com.homeloan.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.homeloan.main.retalitionalmodel.AccountDetails;
import com.homeloan.main.retalitionalmodel.CurrentLoanDetails;
import com.homeloan.main.retalitionalmodel.CustomerAddress;
import com.homeloan.main.retalitionalmodel.CustomerEducationlInfo;
import com.homeloan.main.retalitionalmodel.FamilyDependentInforamtion;
import com.homeloan.main.retalitionalmodel.GuarantorDetails;
import com.homeloan.main.retalitionalmodel.Ledger;
import com.homeloan.main.retalitionalmodel.LoanDisbursement;
import com.homeloan.main.retalitionalmodel.MortgageDetails;
import com.homeloan.main.retalitionalmodel.PreviousLoan;
import com.homeloan.main.retalitionalmodel.Profession;
import com.homeloan.main.retalitionalmodel.CustomerPropertyInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName,customerDateOfBirth,customerGender,customerEmail;
	private Integer customerAge;
	private Double customerMobileNumber,customerAdditionalMobileNumber,
					customerAmountPaidForHome,customerTotalLoanRequired;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerEducationlInfo educationalInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private FamilyDependentInforamtion familydependentInfo;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
	@OneToOne(cascade = CascadeType.ALL)
	private Profession profession;
	@OneToOne(cascade = CascadeType.ALL)
	private MortgageDetails mortgageDetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CurrentLoanDetails currentloandetails;
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoan previousloan;
	@OneToOne(cascade = CascadeType.ALL)
	private AccountDetails accountdetails;
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerPropertyInfo propertyinfo;
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails  gurantordetails;
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loandisbursement;
	@OneToOne(cascade = CascadeType.ALL)
	private Ledger ledger;
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionletter;

}
