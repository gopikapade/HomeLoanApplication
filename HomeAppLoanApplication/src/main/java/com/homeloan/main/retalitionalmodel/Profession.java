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
@NoArgsConstructor
@AllArgsConstructor
public class Profession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer professionid;
	private String professiontype,professionsalaryType,
	professionworkingperiod,
	professionDesignation ;
	private Double professionsalary;
	@Lob
	private byte[] professionsalaryslips;
	

}
