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
public class OperationalExecutive {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oeId;
	private Boolean status;
	private String remark;
	@OneToOne(cascade=CascadeType.ALL)
	private Cibil cibilCheck;
	@OneToOne(cascade=CascadeType.ALL)
	private EnquiryDetails details;
	
}
