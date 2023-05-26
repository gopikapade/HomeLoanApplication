package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.retalitionalmodel.LoanDisbursement;
import com.homeloan.main.service.LoanDisburstmentService;

@CrossOrigin("*")
@RestController
@RequestMapping("/loandis")
public class LoanDisburstmentController {
	
	
	@Autowired
	LoanDisburstmentService loandservice;
	
	
	
	
	@PutMapping("/disbust/{id}")
	public ResponseEntity<BaseResponse<LoanDisbursement>> emidetailsupdate(@PathVariable Integer id, @RequestBody LoanDisbursement loandis){
		
		
		LoanDisbursement details=loandservice.updateloandisbusrtment(id,loandis);
		BaseResponse<LoanDisbursement> baseResponse=new BaseResponse<LoanDisbursement>(200, new Date(),"Emi Update Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<LoanDisbursement>>(baseResponse,HttpStatus.OK);
				
	}
	
	@GetMapping("/disbustdata")
	public ResponseEntity<BaseResponse<Iterable<LoanDisbursement> >> getemidata(){
		Iterable<LoanDisbursement> details=loandservice.getalldata();
		
		BaseResponse<Iterable<LoanDisbursement> > baseResponse=new BaseResponse<Iterable<LoanDisbursement> >(200, new Date(),"Emi Data Get Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<Iterable<LoanDisbursement> >>(baseResponse,HttpStatus.OK);
		
	}
}
