package com.homeloan.main.serviceImpl;



import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.exception.InvalidApplication;
import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.model.PersonalDocuments;
import com.homeloan.main.model.PropertyDocuments;
import com.homeloan.main.model.RelationalExecutive;
import com.homeloan.main.repository.DocumentsRepository;
import com.homeloan.main.repository.EnquiryRepositry;
import com.homeloan.main.service.DocumentsServiceI;
@Service
public class DocumentsServiceImpl implements DocumentsServiceI {
	
	@Autowired
	DocumentsRepository dr; 
    @Autowired
    EnquiryRepositry enquiryRepositry;
	@Override
	public RelationalExecutive saveData(RelationalExecutive re) {
		re.getEnq().setLoanApplication(true);
		return dr.save(re);
	}

	@Override
	public List<RelationalExecutive> getDocuments() {
		
		return dr.findAll();
	}

	@Override
	public RelationalExecutive updateStatus(RelationalExecutive re) {
	
	        Optional<RelationalExecutive> findById = dr.findById(re.getReId());
	    
	 if(findById.isPresent()) {
		    RelationalExecutive relationalExecutive = findById.get();
		    re.setReId(relationalExecutive.getReId());
		    re.setStatus1(true);
		    return dr.save(re);
		    
	 }
	 else {
		 throw new InvalidApplication("Invalid Application request");
	 }
	
	}

	@Override
	public RelationalExecutive updateReamrk(RelationalExecutive re, String msg) {
		  
     Optional<RelationalExecutive> findById = dr.findById(re.getReId());
     
     if(findById.isPresent())
     {
          RelationalExecutive relationalExecutive = findById.get();	  
                              relationalExecutive.setRemark(msg);
                       return   dr.save(relationalExecutive);                             
     }
		
     else {
    	   throw new InvalidApplication("Invalid Application");
     }
	}

	@Override
	public RelationalExecutive saveCMSanctionLetter(RelationalExecutive rx, byte[] readAllBytes) {
		
		            Optional<RelationalExecutive> findById = dr.findById(rx.getReId());
		            
		            if(findById.isPresent()) {
		            	rx.setReId(findById.get().getReId());
		            	rx.setCreditManeger(new CreditManeger());
		            	rx.getCreditManeger().setSanctionLetter(readAllBytes);
		            	return dr.save(rx);
		              }
		            else {
		            	
		            	System.out.println("Not saving the pdf");
		            }
		
		
		
		return null;
	}
	
	
	@Override
	public RelationalExecutive updateDoc(String relexe, MultipartFile addressProof, MultipartFile pancard,
			MultipartFile incomeTax, MultipartFile aadharCard, MultipartFile photo, MultipartFile salarySlip,
			MultipartFile buildingpermission, MultipartFile layout, MultipartFile buildingPlan, MultipartFile estimate,
			MultipartFile noc) throws IOException, IOException {
		
       	
        	
		ObjectMapper mapper = new ObjectMapper();
		RelationalExecutive re1 = mapper.readValue(relexe,RelationalExecutive.class);
    
		    

		
			re1.setPersonalDocuments(new PersonalDocuments());
			re1.getPersonalDocuments().setPropertyDocuments(new PropertyDocuments());
			re1.getPersonalDocuments().setAddressProof(addressProof.getBytes());
			re1.getPersonalDocuments().setPancard(pancard.getBytes());
			re1.getPersonalDocuments().setIncomeTax(incomeTax.getBytes());
			re1.getPersonalDocuments().setAadharCard(aadharCard.getBytes());
			re1.getPersonalDocuments().setPhoto(photo.getBytes());
			re1.getPersonalDocuments().setSalarySlip(salarySlip.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setBuildingpermission(buildingpermission.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setLayout(layout.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setBuildingPlan(buildingPlan.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setEstimate(estimate.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setNoc(noc.getBytes());
        
			//RelationalExecutive re2 = dr.save(re1);
			return dr.save(re1);
	 }

	@Override
	public List<RelationalExecutive> getSanctionLeeters() {
		
		return dr.findAll();
	}

	@Override
	public RelationalExecutive forwordToAh(Integer id) {
		  
		Optional<RelationalExecutive> findById = dr.findById(id);
		if(findById.isPresent()) 
		{
		   RelationalExecutive re = findById.get();
		   re.setStatus2(true);
		   dr.save(re);
		   return re;
		}
		
		else {
			 throw new InvalidApplication("Invalid Application ID");
		}
	}
}
