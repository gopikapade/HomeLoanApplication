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
public class GuarantorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer GuarantorId;
	private String GuarantorName,
	GuarantorDateOfBirth,
	GuarantorRelationshipwithCustomer;
	private Long GuarantorMobileNumber,
	GuarantorAdharCardNo;

}
