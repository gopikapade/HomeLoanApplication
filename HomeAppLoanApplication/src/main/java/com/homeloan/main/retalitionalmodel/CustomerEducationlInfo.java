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
public class CustomerEducationlInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer educationId;
	private String higherEducation;

}
