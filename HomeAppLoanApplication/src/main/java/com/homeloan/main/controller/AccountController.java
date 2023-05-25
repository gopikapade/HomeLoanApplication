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
import com.homeloan.main.retalitionalmodel.AccountDetails;
import com.homeloan.main.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/accountde")
public class AccountController {
	
	
	@Autowired
	AccountService accountservice;
	

	@PutMapping("/accountupdate/{id}")
	public ResponseEntity<BaseResponse<AccountDetails>> account(@PathVariable Integer id,@RequestBody AccountDetails accountdetails){
		
		
		AccountDetails details=accountservice.updateaccountservice(id,accountdetails);
		BaseResponse<AccountDetails> baseResponse=new BaseResponse<AccountDetails>(200, new Date(),"Account Update Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<AccountDetails>>(baseResponse,HttpStatus.OK);
				
	}
	
	@GetMapping("/accountdata")
	public ResponseEntity<BaseResponse<Iterable<AccountDetails> >> getemidata(){
		Iterable<AccountDetails> details=accountservice.getalldata();
		
		BaseResponse<Iterable<AccountDetails> > baseResponse=new BaseResponse<Iterable<AccountDetails> >(200, new Date(),"Emi Data Get Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<Iterable<AccountDetails> >>(baseResponse,HttpStatus.OK);
		
	}
	

}
