package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.retalitionalmodel.CurrentLoanDetails;
import com.homeloan.main.service.EMIDetailsService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping("emiDetails")
public class EMIDetailsController {
  
	
	@Autowired
	EMIDetailsService service;
	
	@PutMapping("/addEmiDetails")
	public ResponseEntity<BaseResponse<CurrentLoanDetails>> updateCurrentLoanDetails(@RequestBody CurrentLoanDetails cld)
	{
		
		
		    CurrentLoanDetails currentLoanDetails = service.updateEmis(cld);
		    
		    BaseResponse<CurrentLoanDetails> baseResponse = 
		    		new BaseResponse<CurrentLoanDetails>(201, new Date(), "EMi Updated", currentLoanDetails);
		    
		    
		    return new ResponseEntity<BaseResponse<CurrentLoanDetails>>(baseResponse, HttpStatus.OK);
		
	   	
		
	}
	
}
