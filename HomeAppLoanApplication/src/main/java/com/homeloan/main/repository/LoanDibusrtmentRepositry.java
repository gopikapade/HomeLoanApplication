package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.retalitionalmodel.LoanDisbursement;

public interface LoanDibusrtmentRepositry extends JpaRepository<LoanDisbursement, Integer> {

}
