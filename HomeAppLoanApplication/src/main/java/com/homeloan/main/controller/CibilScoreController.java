package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.model.Cibil;
import com.homeloan.main.model.EnquiryDetails;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.EnquiryServicei;
import com.homeloan.main.utility.CibilGenerator;
@CrossOrigin("*")
@RestController
public class CibilScoreController {
	

	@Autowired
	EnquiryServicei enquiryServicei;
	
	@PostMapping("/cibil")
	public ResponseEntity<Cibil> getCibilScore(@RequestBody EnquiryDetails details)
	{
		int cibilscrore = CibilGenerator.cibilGenerator();
	    Cibil cibil = new Cibil(null, cibilscrore, new Date(), null, null);
		enquiryServicei.addCibil(cibil, details);
		return new ResponseEntity<Cibil>(cibil,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/remarkadd")
    public ResponseEntity<BaseResponse<EnquiryDetails>> remarkAdded(@RequestBody EnquiryDetails details){
	       
		  EnquiryDetails details2 = enquiryServicei.cibilRemarkUpdated(details);
		       
		  BaseResponse<EnquiryDetails> baseResponse = new BaseResponse<EnquiryDetails>(201, new Date(), "Update remark", details2);
		  
		  return new ResponseEntity<BaseResponse<EnquiryDetails>>(baseResponse, HttpStatus.ACCEPTED);
		
	}

}
