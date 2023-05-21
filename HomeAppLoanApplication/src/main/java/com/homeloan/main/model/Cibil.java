package com.homeloan.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cibil {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Integer cbildId;
	private Integer cbillScore;
    private Date data;
    private Boolean status;
    private String remark;
}
