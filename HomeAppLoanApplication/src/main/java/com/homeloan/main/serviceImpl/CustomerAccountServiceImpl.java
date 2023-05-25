package com.homeloan.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.model.CustomerAccount;
import com.homeloan.main.repository.CustomerAccountRepositry;
import com.homeloan.main.service.CustomerAccountService;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

	@Autowired
	CustomerAccountRepositry custrepo;
	
	@Override
	public CustomerAccount saveCustomerDetails(CustomerAccount account) {
		
		return custrepo.save(account);
	}

	@Override
	public Iterable<CustomerAccount> getAllCustomerAccounts() {
		
		return custrepo.findAll();
	}

	

}
