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
	public ResponseEntity<BaseResponse<Iterable>> getDocument(){
		
		
		Iterable<RelationalExecutive> iterable=dsi.getDocuments();
		BaseResponse<Iterable> baseResponse=new BaseResponse<Iterable>(200, new Date(), "Date Is Get SucessFully", iterable);
		ResponseEntity<BaseResponse<Iterable>> entity=new ResponseEntity<BaseResponse<Iterable>>(baseResponse, HttpStatus.OK);
		return entity;
		
		
		
	}
	
	
	
	
	
	
}
