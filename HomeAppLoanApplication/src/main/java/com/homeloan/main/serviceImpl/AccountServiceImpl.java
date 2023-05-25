package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidIdClassException;
import com.homeloan.main.repository.AccountDetailsRepositry;
import com.homeloan.main.repository.LoanDibusrtmentRepositry;
import com.homeloan.main.retalitionalmodel.AccountDetails;
import com.homeloan.main.retalitionalmodel.LoanDisbursement;
import com.homeloan.main.service.AccountService;
import com.homeloan.main.service.LoanDisburstmentService;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDetailsRepositry accorepo;
	
	@Override
	public AccountDetails updateaccountservice(Integer id, AccountDetails accountdetails) {
		
		Optional<AccountDetails> optional=accorepo.findById(id);
		
		if (optional.isPresent()) {
			accountdetails.setAccountId(optional.get().getAccountId());
			AccountDetails save = accorepo.save(accountdetails);
			
			return save;		
			
		}
		
		else {
			
			throw new InvalidIdClassException("Id Not Found");
			
			
		}
		
	}

	@Override
	public Iterable<AccountDetails> getalldata() {
		
		return accorepo.findAll();
	}

}
