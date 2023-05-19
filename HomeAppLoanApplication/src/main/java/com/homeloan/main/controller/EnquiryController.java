package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.model.EnquiryDetails;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.EnquiryServicei;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
	
	
	@Autowired
	EnquiryServicei enqservice;
	
	
	@PostMapping("/addenquiry")
	public ResponseEntity<BaseResponse<EnquiryDetails>> addenquiry(@RequestBody EnquiryDetails enquiryDetails){
		EnquiryDetails details=enqservice.saveAddEnquiry(enquiryDetails);
		BaseResponse<EnquiryDetails> baseResponse=new BaseResponse<EnquiryDetails>(200, new Date(),"Data Is Added Sucessfully", details);
		return new ResponseEntity<BaseResponse<EnquiryDetails>>(baseResponse, HttpStatus.OK);
				
	}
	
	@GetMapping("/getenquiry")
	public ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>> getenquiry(){
		
		Iterable<EnquiryDetails> iterable=enqservice.getalldata();
		BaseResponse<Iterable<EnquiryDetails>> baseResponse=new BaseResponse<Iterable<EnquiryDetails>>(200, new Date(), "Data Is GEt Sucessfully", iterable);
		return new ResponseEntity<BaseResponse<Iterable<EnquiryDetails>>>(baseResponse, HttpStatus.OK);
		
	}
	
	
	
	
	

}
