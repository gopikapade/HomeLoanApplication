package com.homeloan.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EMI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double LoanAmmount;
	private Integer tenure;
	private Double intrestrate;
	private Double monthlyEmi;
	private Date date = new Date();
<<<<<<< HEAD

=======
	
	
	
>>>>>>> 5d389858b427cdf44d9b6de5ba73e7057bf7f96a
}
