package com.homeloan.main.utility;

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
public class Menues {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer menuId;
	private  String path;
	private  String label;
}
