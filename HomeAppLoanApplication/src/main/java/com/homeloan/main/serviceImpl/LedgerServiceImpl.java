package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidIdClassException;
import com.homeloan.main.repository.LedgerRepositry;
import com.homeloan.main.retalitionalmodel.Ledger;
import com.homeloan.main.service.LedgerService;
@Service
public class LedgerServiceImpl implements LedgerService {

	@Autowired
	LedgerRepositry ledgerrepo;
	
	@Override
	public Ledger ledgerupdate(Integer id, Ledger accountdetails) {
		
		Optional<Ledger> optional=ledgerrepo.findById(id);
		
		if (optional.isPresent()) {
			accountdetails.setLedgerId(optional.get().getLedgerId());
			Ledger save = ledgerrepo.save(accountdetails);
			
			return save;		
			
		}
		
		else {
			
			throw new InvalidIdClassException("Id Not Found");
			
			
		}
		
	}

	@Override
	public Iterable<Ledger> getledgerdata() {
		
		return ledgerrepo.findAll();
	}

}
