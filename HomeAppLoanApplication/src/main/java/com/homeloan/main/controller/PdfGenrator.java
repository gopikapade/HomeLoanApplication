package com.homeloan.main.controller;

import java.io.ByteArrayInputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.model.CreditManeger;
import com.homeloan.main.model.RelationalExecutive;
import com.homeloan.main.model.SanctionLetter;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.CreditManagerService;
import com.homeloan.main.service.DocumentsServiceI;
import com.homeloan.main.service.PdfGenratorService;


@RestController
@CrossOrigin("*")
@RequestMapping("/pdf")
public class PdfGenrator {

	@Autowired
	PdfGenratorService pdfservice;
	
	@Autowired
	DocumentsServiceI dsi;
	
	@Autowired
	CreditManagerService creditManagerService;
	
	

	@GetMapping("/getpdf")
	public ResponseEntity<InputStreamResource> createPdf() {
		
		ByteArrayInputStream createpdf = pdfservice.createpdf();
					
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("content Disposition", "inline;file=Sanctionlatter");
		
		
		
		return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(createpdf));
		
		
	}
	
	@PutMapping("/sanctionletterpdf/{letter}")
	public ResponseEntity<BaseResponse<RelationalExecutive>> generateSanctionLetterPdf(@PathVariable String letter, @RequestBody RelationalExecutive rx) throws JsonMappingException, JsonProcessingException {
		
		
		 ObjectMapper omMapper = new ObjectMapper();
		  SanctionLetter readValue = omMapper.readValue(letter, SanctionLetter.class);
	    
          ByteArrayInputStream createpdf = pdfservice.createSanctionLetterpdf(readValue);
          
         
            byte[] readAllBytes = createpdf.readAllBytes();
					
		    
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.add("Content-Disposition", "inline; filename=SanctionLetter.pdf");
            
		
		   RelationalExecutive relationalExecative  = dsi.saveCMSanctionLetter(rx,readAllBytes);
		
		   BaseResponse<RelationalExecutive> baseResponse = new BaseResponse<RelationalExecutive>(201, new Date(), "Pdf save", relationalExecative);
		   
		   
		  return  new ResponseEntity<BaseResponse<RelationalExecutive>>(baseResponse, HttpStatus.OK); 
		
		
		
	   
	}
	
	
	
}
