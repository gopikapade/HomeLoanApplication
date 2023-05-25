package com.homeloan.main.service;

import com.homeloan.main.retalitionalmodel.EMIDetails;
import com.homeloan.main.retalitionalmodel.LoanDisbursement;

public interface LoanDisburstmentService {

	public LoanDisbursement updateloandisbusrtment(Integer id, LoanDisbursement loandis);

	public Iterable<LoanDisbursement> getalldata();

}
