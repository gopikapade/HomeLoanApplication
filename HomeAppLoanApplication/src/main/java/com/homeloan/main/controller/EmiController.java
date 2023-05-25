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
import com.homeloan.main.retalitionalmodel.EMIDetails;
import com.homeloan.main.service.CustomerEMIDetailsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/custemi")
public class EmiController {
	
	
	@Autowired
	CustomerEMIDetailsService customerEmi;
	
	
	@PutMapping("/emiupdate/{id}")
	public ResponseEntity<BaseResponse<EMIDetails>> emidetailsupdate(@PathVariable Integer id,@RequestBody EMIDetails emidata){
		
		
		EMIDetails details=customerEmi.updateEmi(id,emidata);
		BaseResponse<EMIDetails> baseResponse=new BaseResponse<EMIDetails>(200, new Date(),"Emi Update Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<EMIDetails>>(baseResponse,HttpStatus.OK);
				
	}
	
	@GetMapping("/emidata")
	public ResponseEntity<BaseResponse<Iterable<EMIDetails> >> getemidata(){
		Iterable<EMIDetails> details=customerEmi.getallemi();
		
		BaseResponse<Iterable<EMIDetails> > baseResponse=new BaseResponse<Iterable<EMIDetails> >(200, new Date(),"Emi Data Get Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<Iterable<EMIDetails> >>(baseResponse,HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
