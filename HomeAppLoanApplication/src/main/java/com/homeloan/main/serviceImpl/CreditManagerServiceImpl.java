package com.homeloan.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.repository.CreditmanagerRepositry;
import com.homeloan.main.service.CreditManagerService;
@Service
public class CreditManagerServiceImpl implements CreditManagerService {

	
	@Autowired
	CreditmanagerRepositry crrepo;
	
	@Override
	public CreditManeger saveCreditManager(CreditManeger creditmanagervalue) {
		
		return crrepo.save(creditmanagervalue);
	}

	@Override
	public Iterable<CreditManeger> getcm() {
		
		return crrepo.findAll();
	}
}
