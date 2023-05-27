package com.homeloan.main.retalitionalmodel;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerPropertyDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyDocid;
	@Lob
	private byte[] buildingpermission;
	@Lob
	private byte[] layout;
	@Lob
	private byte[] buildingPlan;
	@Lob
	private byte[] estimate;
	@Lob
	private byte[] noc;
	

}
