package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.model.EMI;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.utility.EmiCalculator;
@CrossOrigin("*")
@RestController
@RequestMapping("/emi")
public class EMICalculatorController {
	
	 @GetMapping("/emicalculate/{emi1}")
	 public ResponseEntity<BaseResponse<EMI>> calculateEMI(@PathVariable String emi1) throws JsonMappingException, JsonProcessingException {
		 
		    ObjectMapper mapper = new ObjectMapper();
		    EMI emi = mapper.readValue(emi1, EMI.class);                          
	        double principleAmmount = emi.getLoanAmmount();
	        double intrestrate = emi.getIntrestrate();
	        int tenure = emi.getTenure();
	        double monthly_emi=EmiCalculator.calculateEMI(principleAmmount, intrestrate, tenure);
	        emi.setMonthlyEmi(monthly_emi);
	        BaseResponse<EMI> baseresponse=new BaseResponse<EMI>(200,new Date(),"Monthly EMI Added Successfully",emi);
	        return new ResponseEntity<BaseResponse<EMI>> (baseresponse,HttpStatus.OK);
	    }
}
