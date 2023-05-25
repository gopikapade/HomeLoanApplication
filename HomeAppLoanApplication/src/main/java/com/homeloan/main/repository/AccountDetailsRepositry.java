package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.retalitionalmodel.AccountDetails;

public interface AccountDetailsRepositry extends JpaRepository<AccountDetails, Integer> {

}
