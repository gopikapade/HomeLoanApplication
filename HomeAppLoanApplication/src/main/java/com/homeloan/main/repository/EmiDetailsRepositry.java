package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.retalitionalmodel.EMIDetails;

public interface EmiDetailsRepositry extends JpaRepository<EMIDetails, Integer> {

}
