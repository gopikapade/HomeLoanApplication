package com.homeloan.main.service;

import java.util.List;

import com.homeloan.main.model.CustomerAccount;

public interface CustomerAccountService {

	public CustomerAccount saveCustomerDetails(CustomerAccount account);

	public Iterable<CustomerAccount> getAllCustomerAccounts();

	
}
