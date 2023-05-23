package com.homeloan.main.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RelationalExecutive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reId;
	private String remark;
	private Boolean status1;
	private Boolean status2;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EnquiryDetails enq;
	@OneToOne(cascade=CascadeType.ALL)
	private PersonalDocuments personalDocuments;
	
}
