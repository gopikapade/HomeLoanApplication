package com.homeloan.main.service;

import java.util.List;

import com.homeloan.main.model.Cibil;
import com.homeloan.main.model.EnquiryDetails;

public interface EnquiryServicei {

	public EnquiryDetails saveAddEnquiry(EnquiryDetails enquiryDetails);

	public List<EnquiryDetails> getalldata();

	public EnquiryDetails oeForword(Integer id,EnquiryDetails enquiry);

	public void addCibil(Cibil cibil, EnquiryDetails details);

	public EnquiryDetails cibilRemarkUpdated(EnquiryDetails details);

	public void deleteData(Integer enquryId);

}
