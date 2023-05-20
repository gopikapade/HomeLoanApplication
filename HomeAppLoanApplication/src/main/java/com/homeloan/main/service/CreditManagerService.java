package com.homeloan.main.service;

import com.homeloan.main.model.CreditManeger;

public interface CreditManagerService {

	public CreditManeger saveCreditManager(CreditManeger creditmanagervalue);

	public Iterable<CreditManeger> getcm();

}
