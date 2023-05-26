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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerPropertyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer propertyId;
	private String propertyType,
	propertyArea,
	constructionArea;
	private Double propertyPrice,
	constructionPrice;
	@OneToOne(cascade = CascadeType.ALL )
	private CustomerPropertyDocuments propertydocuments;
	@OneToOne(cascade = CascadeType.ALL )
	private PropertyAddress propertyAddress;


}
