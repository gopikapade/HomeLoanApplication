package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidIdClassException;
import com.homeloan.main.repository.LoanDibusrtmentRepositry;

import com.homeloan.main.retalitionalmodel.LoanDisbursement;
import com.homeloan.main.service.LoanDisburstmentService;
@Service
public class LoanDisburstmentServiceImpl implements LoanDisburstmentService {

	@Autowired
	LoanDibusrtmentRepositry loanDibusrtmentRepositry;
	
	@Override
	public LoanDisbursement updateloandisbusrtment(Integer id, LoanDisbursement loandis) {
		
		Optional<LoanDisbursement> optional=loanDibusrtmentRepositry.findById(id);
		
		if (optional.isPresent()) {
			loandis.setLoanDisbursementid(optional.get().getLoanDisbursementid());
			LoanDisbursement save = loanDibusrtmentRepositry.save(loandis);
			
			return save;		
			
		}
		
		else {
			
			throw new InvalidIdClassException("Id Not Found");
			
			
		}
		
	}

	@Override
	public Iterable<LoanDisbursement> getalldata() {
		
		return loanDibusrtmentRepositry.findAll();
	}

}
