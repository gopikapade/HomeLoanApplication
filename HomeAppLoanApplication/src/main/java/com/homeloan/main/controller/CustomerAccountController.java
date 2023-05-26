package com.homeloan.main.controller;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.model.CustomerAccount;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.retalitionalmodel.CustomerPropertyDocuments;
import com.homeloan.main.service.CustomerAccountService;

@RestController
@CrossOrigin("*")
@RequestMapping("/customeraccount")
public class CustomerAccountController {

	@Autowired
	CustomerAccountService cusservice;

	@PostMapping("/createcustomeraccount")
	public ResponseEntity<BaseResponse<CustomerAccount>> createCustomerAccount(
			@RequestParam("customeraccount") String customeraccount,
			@RequestParam("professionsalaryslips") MultipartFile professionsalaryslips,
			@RequestParam("mortgagePropertyProof") MultipartFile mortgagePropertyProof,
			@RequestParam("mortgagePropertyInsurance") MultipartFile mortgagePropertyInsurance,

			@RequestParam("buildingpermission") MultipartFile buildingpermission,
			@RequestParam("layout") MultipartFile layout, @RequestParam("buildingPlan") MultipartFile buildingPlan,
			@RequestParam("estimate") MultipartFile estimate, @RequestParam("noc") MultipartFile noc

	) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		CustomerAccount account = mapper.readValue(customeraccount, CustomerAccount.class);


		account.getProfession().setProfessionsalaryslips(professionsalaryslips.getBytes());

		account.getMortgageDetails().setMortgagePropertyInsurance(mortgagePropertyInsurance.getBytes());
		account.getMortgageDetails().setMortgagePropertyProof(mortgagePropertyProof.getBytes());


		account.getPropertyinfo().setPropertydocuments(new CustomerPropertyDocuments());
		account.getPropertyinfo().getPropertydocuments().setBuildingpermission(buildingpermission.getBytes());
		account.getPropertyinfo().getPropertydocuments().setLayout(layout.getBytes());
		account.getPropertyinfo().getPropertydocuments().setBuildingPlan(buildingPlan.getBytes());
		account.getPropertyinfo().getPropertydocuments().setEstimate(estimate.getBytes());
		account.getPropertyinfo().getPropertydocuments().setNoc(noc.getBytes());

		CustomerAccount customerAccount2 = cusservice.saveCustomerDetails(account);
		BaseResponse<CustomerAccount> baseResponse = new BaseResponse<CustomerAccount>(200, new Date(),
				"Data Is Added Sucessfully", customerAccount2);

		return new ResponseEntity<BaseResponse<CustomerAccount>>(baseResponse, HttpStatus.OK);

	}
	
	
	
	 @GetMapping("/getalldata")
	    public ResponseEntity<BaseResponse<Iterable<CustomerAccount>>> getAllData() {
		 Iterable<CustomerAccount> customerAccounts = cusservice.getAllCustomerAccounts();

		

			BaseResponse<Iterable<CustomerAccount>> baseResponse = new BaseResponse<>(200, new Date(),
			        "All Customer Accounts", customerAccounts);
			return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	
	
	 }
	 
	 
	 
}
