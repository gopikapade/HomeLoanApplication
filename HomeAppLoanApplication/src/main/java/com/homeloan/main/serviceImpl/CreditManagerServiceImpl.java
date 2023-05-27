package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidIdClassException;
import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.model.EMI;
import com.homeloan.main.repository.CreditmanagerRepositry;
import com.homeloan.main.service.CreditManagerService;
@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	
	@Autowired
	CreditmanagerRepositry crrepo;
	
	@Override
	public CreditManeger saveCreditManager(CreditManeger creditmanagervalue) {
		creditmanagervalue.setEmi(new EMI());
		return crrepo.save(creditmanagervalue);
	}

	@Override
	public Iterable<CreditManeger> getcm() {
		
		return crrepo.findAll();
	}

	@Override
	public Object saveSanctionLetter(byte[] readAllBytes) {
		
		return null;
	}

	@Override
	public CreditManeger emiupdate(Integer id, EMI emi) {
		Optional<CreditManeger> optional=crrepo.findById(id);
		System.out.println();
		if (optional.isPresent()) {
			CreditManeger creditManeger = optional.get();
			creditManeger.setId(optional.get().getId());
			
		
		
			emi.setId(creditManeger.getEmi().getId());
			System.out.println(creditManeger.getEmi().getId());
			creditManeger.setEmi(emi);
		return	crrepo.save(creditManeger);
			
			
		}
			else {
				throw new InvalidIdClassException("Creadit Maneger Id Not Found");
				
			}
			
		
	}

	
}
