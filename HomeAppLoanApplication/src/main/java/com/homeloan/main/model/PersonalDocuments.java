package com.homeloan.main.model;





import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonalDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer documentId;
	@Lob
	private byte[] addressProof;
	@Lob
	private byte[] pancard;
	@Lob
	private byte[] incomeTax;
	@Lob
	private byte[] aadharCard;
	@Lob
	private byte[] photo;
	@Lob
	private byte[] salarySlip;
	@OneToOne(cascade=CascadeType.ALL)
	private PropertyDocuments propertyDocuments;
	
	

}
