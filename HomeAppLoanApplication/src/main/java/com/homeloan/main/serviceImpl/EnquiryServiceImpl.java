package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidEnquiry;
import com.homeloan.main.model.Cibil;
import com.homeloan.main.model.EnquiryDetails;
import com.homeloan.main.repository.EnquiryRepositry;
import com.homeloan.main.service.EnquiryServicei;
@Service
public class EnquiryServiceImpl implements EnquiryServicei {

	@Autowired
	EnquiryRepositry enqrepo;
	
	@Override
	public EnquiryDetails saveAddEnquiry(EnquiryDetails enquiryDetails)
	 {
		return enqrepo.save(enquiryDetails);
	 }

	@Override
	public Iterable<EnquiryDetails> getalldata() 
	{
        return enqrepo.findAll();
	}

	@Override
	public EnquiryDetails oeForword(Integer id, EnquiryDetails enquiry) {
		   Optional<EnquiryDetails> findById = enqrepo.findById(id);
		      
		   if(findById.isPresent()) 
		   {
			     EnquiryDetails enquiryDetails = findById.get();
			     enquiryDetails.setForwardToOe(true);
			     enqrepo.save(enquiryDetails);
			     return enquiryDetails;
		   }
		   
		return null;
	}

	@Override
	public void addCibil(Cibil cibil, EnquiryDetails enquiryDetails) {
		
	  Optional<EnquiryDetails> findById = enqrepo.findById(enquiryDetails.getEnquryId());
	     
	     if(findById.isPresent()) {
	    	   EnquiryDetails enquiryDetails2 = findById.get();
	    	   enquiryDetails.setEnquryId(enquiryDetails2.getEnquryId());
	    	   enquiryDetails.setCibilEnquiry(cibil);
	    	   enqrepo.save(enquiryDetails);
	     }else {
	    	 throw new InvalidEnquiry("Enquiry not present");
	     }
	     
		
	}

	@Override
	public EnquiryDetails cibilRemarkUpdated(EnquiryDetails details)
	{
		   
		Optional<EnquiryDetails> findById = enqrepo.findById(details.getEnquryId());
	     
	     if(findById.isPresent()) {
	    	  
	    	 EnquiryDetails enquiryDetails = findById.get();
	    	 enquiryDetails.getCibilEnquiry().setRemark(details.getCibilEnquiry().getRemark());
	    	 
	    	 return  enqrepo.save(enquiryDetails);
	    	   
	     }else 
	     {
	    	 throw new InvalidEnquiry("Enquiry not present");
	     }
		
	}
	
	
	@Override
	public void deleteData(Integer enquryId) {
		Optional<EnquiryDetails> findById = enqrepo.findById(enquryId);
		if(findById.isPresent()) {
			enqrepo.deleteById(findById.get().getEnquryId());
		}
		else {
			
			throw new InvalidEnquiry("This Enquiry does not exist!");
		
		}
		
	}

}
