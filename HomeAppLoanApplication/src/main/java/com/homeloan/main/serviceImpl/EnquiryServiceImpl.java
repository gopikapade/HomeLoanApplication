package com.homeloan.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.model.EnquiryDetails;
import com.homeloan.main.repository.EnquiryRepositry;
import com.homeloan.main.service.EnquiryServicei;
@Service
public class EnquiryServiceImpl implements EnquiryServicei {

	@Autowired
	EnquiryRepositry enqrepo;
	
	@Override
	public EnquiryDetails saveAddEnquiry(EnquiryDetails enquiryDetails) {
		
		
		
		return enqrepo.save(enquiryDetails);
		
		
	}

	@Override
	public Iterable<EnquiryDetails> getalldata() {
		
		return enqrepo.findAll();
	}

}
