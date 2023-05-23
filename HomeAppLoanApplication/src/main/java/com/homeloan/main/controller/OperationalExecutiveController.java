package com.homeloan.main.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.model.OperationalExecutive;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.OperationalExecutiveServiceI;

@CrossOrigin("*")
@RestController
public class OperationalExecutiveController {
	
	@Autowired
	OperationalExecutiveServiceI oes;
	
	
	
	@PostMapping("/oeenquiry")
	public ResponseEntity<BaseResponse<OperationalExecutive>> addData(@RequestBody OperationalExecutive operationalExecutive)
	{
		OperationalExecutive oe = oes.saveData(operationalExecutive);
		BaseResponse<OperationalExecutive> baseResponse = new BaseResponse<OperationalExecutive>
		(200, new Date(),"Data Added Successfully", oe);
		return new ResponseEntity<BaseResponse<OperationalExecutive>>(baseResponse, HttpStatus.OK);
	}
	@GetMapping("/doc")
	public ResponseEntity<BaseResponse<List<OperationalExecutive>>> getData()
	{
		List<OperationalExecutive> oe = oes.getData();
		BaseResponse<List<OperationalExecutive>> baseResponse = new BaseResponse<List<OperationalExecutive>>
		(200, new Date(),"Data", oe);
		return new ResponseEntity<BaseResponse<List<OperationalExecutive>>>(baseResponse, HttpStatus.OK);
	}
	

	
	

}
