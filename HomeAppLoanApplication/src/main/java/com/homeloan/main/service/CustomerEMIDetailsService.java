package com.homeloan.main.service;

import com.homeloan.main.retalitionalmodel.EMIDetails;

public interface CustomerEMIDetailsService {

	public EMIDetails updateEmi(Integer id, EMIDetails emidata);

	public Iterable<EMIDetails> getallemi();

}
