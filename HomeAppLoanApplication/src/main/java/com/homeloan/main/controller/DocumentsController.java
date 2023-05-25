package com.homeloan.main.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.homeloan.main.model.PersonalDocuments;
import com.homeloan.main.model.PropertyDocuments;
import com.homeloan.main.model.RelationalExecutive;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.DocumentsServiceI;

@CrossOrigin("*")
@RestController
@RequestMapping("/documents")
public class DocumentsController {
	
	@Autowired
	DocumentsServiceI dsi;
	
	@PostMapping("/adddocuments")
	public ResponseEntity<BaseResponse<RelationalExecutive>> saveUser(@RequestParam("re") String relexe,
			@RequestParam("addressProof") MultipartFile addressProof,
			@RequestParam("pancard") MultipartFile pancard,
			@RequestParam("incomeTax") MultipartFile incomeTax,
			@RequestParam("aadharCard") MultipartFile aadharCard,
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("salarySlip") MultipartFile salarySlip,
			@RequestParam("buildingpermission") MultipartFile buildingpermission,
			@RequestParam("layout") MultipartFile layout,
			@RequestParam("buildingPlan") MultipartFile buildingPlan,
			@RequestParam("estimate") MultipartFile estimate,
			@RequestParam("noc") MultipartFile noc
			
	) throws IOException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		RelationalExecutive re1 = mapper.readValue(relexe, RelationalExecutive.class);
		
			re1.setPersonalDocuments(new PersonalDocuments());
			re1.getPersonalDocuments().setPropertyDocuments(new PropertyDocuments());
			re1.getPersonalDocuments().setAddressProof(addressProof.getBytes());
			re1.getPersonalDocuments().setPancard(pancard.getBytes());
			re1.getPersonalDocuments().setIncomeTax(incomeTax.getBytes());
			re1.getPersonalDocuments().setAadharCard(aadharCard.getBytes());
			re1.getPersonalDocuments().setPhoto(photo.getBytes());
			re1.getPersonalDocuments().setSalarySlip(salarySlip.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setBuildingpermission(buildingpermission.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setLayout(layout.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setBuildingPlan(buildingPlan.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setEstimate(estimate.getBytes());
			re1.getPersonalDocuments().getPropertyDocuments().setNoc(noc.getBytes());
			
			RelationalExecutive re2 = dsi.saveData(re1);
			BaseResponse<RelationalExecutive> baseResponse=new BaseResponse<RelationalExecutive>(200, new Date(),"Data Is Added Sucessfully", re2);
			ResponseEntity<BaseResponse<RelationalExecutive>> entity=new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.OK);
			return entity;
	
	}
	
	@GetMapping("/getdocuments")
	public ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>> getDocument(){
		
		List<RelationalExecutive> list =  dsi.getDocuments();
		
    //List<RelationalExecutive> collect = list.stream().filter(rx->rx.getStatus2()!=null).collect(Collectors.toList());  
		
		
		BaseResponse<Iterable<RelationalExecutive>> baseResponse=new BaseResponse<Iterable<RelationalExecutive>>(200, new Date(), "Date Is Get SucessFully", list);
		ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>> entity=new ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>>(baseResponse, HttpStatus.OK);
		return entity;
		
	}
	
	@PutMapping("/updateStaus")
	public ResponseEntity<BaseResponse<RelationalExecutive>> updateStatus(@RequestBody RelationalExecutive re){
		
		   RelationalExecutive getRe = dsi.updateStatus(re);
		   BaseResponse<RelationalExecutive> baseResponse = new BaseResponse<RelationalExecutive>(201, new Date(), "Document verified", getRe);
		   return new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.ACCEPTED);
	} 
	
	
	
	@PutMapping("/updatedocuments")
	public ResponseEntity<BaseResponse<RelationalExecutive>> updateDocument( @RequestParam("re") String relexe,
			@RequestParam("addressProof") MultipartFile addressProof,
			@RequestParam("pancard") MultipartFile pancard,
			@RequestParam("incomeTax") MultipartFile incomeTax,
			@RequestParam("aadharCard") MultipartFile aadharCard,
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("salarySlip") MultipartFile salarySlip,
			@RequestParam("buildingpermission") MultipartFile buildingpermission,
			@RequestParam("layout") MultipartFile layout,
			@RequestParam("buildingPlan") MultipartFile buildingPlan,
			@RequestParam("estimate") MultipartFile estimate,
			@RequestParam("noc") MultipartFile noc) throws IOException
	{
		
			
		RelationalExecutive relExe = dsi.updateDoc(relexe,addressProof,pancard,incomeTax,aadharCard,photo,salarySlip,buildingpermission,layout,buildingPlan,estimate,noc);
		BaseResponse<RelationalExecutive> baseResponse=new BaseResponse<RelationalExecutive>(200, new Date(),"Data updated Sucessfully", relExe);
		ResponseEntity<BaseResponse<RelationalExecutive>> entity=new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.OK);
		return entity;
		
		
	}
	
	
	@PutMapping("/updateremark/{msg}")
	public ResponseEntity<BaseResponse<RelationalExecutive>> updateReamark(@RequestBody RelationalExecutive re,@PathVariable String msg){
		   RelationalExecutive getRe = dsi.updateReamrk(re, msg);
		   BaseResponse<RelationalExecutive> baseResponse = new BaseResponse<RelationalExecutive>(201, new Date(), "Reamrked Document", getRe);
		   return new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.ACCEPTED);
	} 
	
	@GetMapping("/getSanctionLetters")
	public ResponseEntity<BaseResponse<List<RelationalExecutive>>> getSanctionLetters(){
      
		     
		List<RelationalExecutive> relationalExecative   = dsi.getSanctionLeeters();
		
		   List<RelationalExecutive> collect = relationalExecative.stream().filter(ex->ex.getCreditManeger()!=null).collect(Collectors.toList());
		
		   BaseResponse<List<RelationalExecutive>> baseResponse = new BaseResponse<List<RelationalExecutive>>(201, new Date(), "All Santion Letters", collect);
		   
		   return new ResponseEntity<BaseResponse<List<RelationalExecutive>>>(baseResponse, HttpStatus.OK);
		
	}
	
	@PutMapping("/forwardToAh/{id}")
	public ResponseEntity<BaseResponse<RelationalExecutive>> forwordToAh(@PathVariable Integer id,  @RequestBody RelationalExecutive sanction){
		
                RelationalExecutive re	= 	dsi.forwordToAh(id);
		   
                BaseResponse<RelationalExecutive> baseResponse = new BaseResponse<RelationalExecutive>(201,new Date() , "Forword To ah", re);
                 
                return new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.OK);
		
	}
	
	@GetMapping("/allSanctionLoan")
	public ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>> getAllSanctionLoan(){
		     List<RelationalExecutive> list =  dsi.getDocuments();
		     List<RelationalExecutive> collect = list.stream().filter(rx->rx.getStatus2()!=null).collect(Collectors.toList());  
			 BaseResponse<Iterable<RelationalExecutive>> baseResponse=new BaseResponse<Iterable<RelationalExecutive>>(200, new Date(), "Date Is Get SucessFully", collect);
			 ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>> entity=new ResponseEntity<BaseResponse<Iterable<RelationalExecutive>>>(baseResponse, HttpStatus.OK);
			 return entity;

	}
	
	
		
}
