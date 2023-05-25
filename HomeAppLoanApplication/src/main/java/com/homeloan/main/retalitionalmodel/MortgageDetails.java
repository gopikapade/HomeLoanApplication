package com.homeloan.main.retalitionalmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MortgageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mortgageId;
	private Double mortgagePropertyValue,mortgageLoanOnProperty; 
	private String mortgagePropertyType;
	@Lob
	private byte[] mortgagePropertyProof,mortgagePropertyInsurance;
}
