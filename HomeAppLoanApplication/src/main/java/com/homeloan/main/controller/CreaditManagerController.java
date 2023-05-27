package com.homeloan.main.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.model.EMI;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.CreditManagerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cm")

public class CreaditManagerController {
	@Autowired
	CreditManagerService cmservice;
	
	@PostMapping("/addcm")
	public ResponseEntity<BaseResponse< CreditManeger>> addCreaditmanager(
			@RequestParam("creditManager") String creditmanagaer,
			@RequestParam("sanctionLetter") MultipartFile sanctionLetter			
			
			) throws Exception, IOException{
		ObjectMapper mapper=new ObjectMapper();
			CreditManeger creditmanagervalue = mapper.readValue(creditmanagaer, CreditManeger.class);
			creditmanagervalue.setSanctionLetter(sanctionLetter.getBytes());	
		CreditManeger cmser	=cmservice.saveCreditManager(creditmanagervalue);
		
		BaseResponse<CreditManeger> baseResponse=new BaseResponse<CreditManeger>(200, new Date(), "Data Is Added Sucessfully", cmser);
		
		return new ResponseEntity<BaseResponse< CreditManeger>>(baseResponse, HttpStatus.OK);
	}
	
	@PutMapping("/emiupdate/{id}")
	public ResponseEntity<BaseResponse<CreditManeger>> updateemidetails(@PathVariable Integer id,@RequestBody EMI emi)
	{
	CreditManeger cmupdateforemi=cmservice.emiupdate(id,emi);
	BaseResponse<CreditManeger> baseResponse=new BaseResponse<CreditManeger>(200, new Date(), "Emi Data Is Updated Sucessfully", cmupdateforemi);
	
	return new ResponseEntity<BaseResponse< CreditManeger>>(baseResponse, HttpStatus.OK);
		
	}
	
	
	
//	@GetMapping(value = "/getcm" ,produces = "application/pdf")
//	public ResponseEntity<Iterable<CreditManeger>> getcm()
//	{
//	Iterable<CreditManeger> iterable=cmservice.getcm();
//	return new ResponseEntity<Iterable<CreditManeger>>(iterable, HttpStatus.OK);
//	}
//	
	

}
