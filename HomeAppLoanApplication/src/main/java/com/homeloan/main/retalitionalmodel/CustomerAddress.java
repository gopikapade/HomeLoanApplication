package com.homeloan.main.retalitionalmodel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer	localAddressId;
	private String areaname,
	cityname,
	district,
	state;
	private Long pincode;
	@OneToOne(cascade = CascadeType.ALL)
	private PermanentAddress permanantAddress;

}
