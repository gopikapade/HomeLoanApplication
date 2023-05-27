package com.homeloan.main.service;

import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.model.EMI;

public interface CreditManagerService {

	public CreditManeger saveCreditManager(CreditManeger creditmanagervalue);

	public Iterable<CreditManeger> getcm();

	public Object saveSanctionLetter(byte[] readAllBytes);

	public CreditManeger emiupdate(Integer id, EMI emi);

}
