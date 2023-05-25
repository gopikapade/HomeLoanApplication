package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.model.CustomerAccount;

public interface CustomerAccountRepositry extends JpaRepository<CustomerAccount, Integer> {

}
