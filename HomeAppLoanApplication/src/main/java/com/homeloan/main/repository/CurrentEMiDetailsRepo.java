package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.retalitionalmodel.CurrentLoanDetails;

public interface CurrentEMiDetailsRepo extends JpaRepository<CurrentLoanDetails, Integer>{

	
	
	
}
