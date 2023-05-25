package com.homeloan.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeloan.main.exception.InvalidEmailAddress;
import com.homeloan.main.model.EmailSender;
import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.EmailSenderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/mail")
public class EmailSenderController {
	
	@Autowired
	EmailSenderService emaiservice;
	
	@Value("${spring.mail.username}")
	String username;
	
	@PostMapping("/send")
	public String emailsend(@RequestBody EmailSender e)
	{
		e.setFrom(username);
		
		try {
			
			emaiservice.sendemail(e);
			
		} catch (Exception e2) {
			e2.printStackTrace();
			return "fail";
		}
		
		
		return "Email Send Sucessfully";
	}
	
	@PostMapping("/sendattachement")
	public ResponseEntity<BaseResponse<String>> emailwithattachement(@RequestParam("file") MultipartFile file,
			@RequestParam("data") String data)
	{
		
		try {
			ObjectMapper objectMapper=new ObjectMapper();
			EmailSender emailSender=objectMapper.readValue(data,EmailSender.class);
			emailSender.setFrom(username);
			
			emaiservice.sendmailwithattachemnt(emailSender,file);
			
			BaseResponse<String> baseResponse = new BaseResponse<String>
			(201, new Date(), "Mail Send Sucessfully", "Mail Send Sucessfully");
			return new ResponseEntity<BaseResponse<String>>(baseResponse, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidEmailAddress("Invalid Mail Address");
			
		}
		
		
	}
	
	
	
	
	

}
