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
import com.homeloan.main.retalitionalmodel.Ledger;
import com.homeloan.main.service.LedgerService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ledger")
public class LedgerController {
	
	
	@Autowired
	LedgerService ledgerservice;
	
	@PutMapping("/ledgerupdate/{id}")
	public ResponseEntity<BaseResponse<Ledger>> ledgerupdate(@PathVariable Integer id,@RequestBody Ledger accountdetails){
		
		
		Ledger details=ledgerservice.ledgerupdate(id,accountdetails);
		BaseResponse<Ledger> baseResponse=new BaseResponse<Ledger>(200, new Date(),"Emi Update Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<Ledger>>(baseResponse,HttpStatus.OK);
				
	}
	
	@GetMapping("/ledgerdata")
	public ResponseEntity<BaseResponse<Iterable<Ledger> >> getledger(){
		Iterable<Ledger> details=ledgerservice.getledgerdata();
		
		BaseResponse<Iterable<Ledger> > baseResponse=new BaseResponse<Iterable<Ledger> >(200, new Date(),"Emi Data Get Sucessfully", details);
		
		return new ResponseEntity<BaseResponse<Iterable<Ledger> >>(baseResponse,HttpStatus.OK);
		
	}
	
	

}
