package com.homeloan.main.utility;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.homeloan.main.model.SanctionLetter;
import com.homeloan.main.service.PdfGenratorService;

public class PdfSanctionLetter {
	
	@Autowired
	static PdfGenratorService pdfservice;
	
	
	
//	public static InputStreamResource generateSanctionLetterPdf(SanctionLetter letter) {
//	    
//		ByteArrayInputStream createpdf = pdfservice.createSanctionLetterpdf(letter);
//							
//				
//				HttpHeaders headers=new HttpHeaders();
//				headers.add("content Disposition", "inline;file=Sanctionlatter");
//				
//				
//				return new InputStreamResource(createpdf);
//					
//				
//			   
//			}
	
	
	public static ResponseEntity<InputStreamResource> generateSanctionLetterPdf(SanctionLetter letter) {
	    
		ByteArrayInputStream createpdf = pdfservice.createSanctionLetterpdf(letter);
				HttpHeaders headers=new HttpHeaders();
				headers.add("content Disposition", "inline;file=Sanctionlatter");
				
				return  ResponseEntity.ok().headers(headers).contentType
						(MediaType.APPLICATION_PDF).body(new InputStreamResource(createpdf));
		   
			}
	
	
	
	

}
