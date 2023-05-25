package com.homeloan.main.retalitionalmodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDependentInforamtion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer	dependentInfoId;
	private String fatherName,motherName,spouseName,maritalStatus,dependentMember;
	private Double familyIncome;
	private Integer noOfFamilyMember,
	noOfChild;
	
}
