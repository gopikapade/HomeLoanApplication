package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.model.EnquiryDetails;

public interface EnquiryRepositry extends JpaRepository<EnquiryDetails, Integer> {

	

}
