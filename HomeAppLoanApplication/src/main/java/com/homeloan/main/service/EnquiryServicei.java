package com.homeloan.main.service;

import com.homeloan.main.model.EnquiryDetails;

public interface EnquiryServicei {

	public EnquiryDetails saveAddEnquiry(EnquiryDetails enquiryDetails);

	public Iterable<EnquiryDetails> getalldata();

}
