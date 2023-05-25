package com.homeloan.main.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.homeloan.main.model.EmailSender;
import com.homeloan.main.service.EmailSenderService;

@Service
public class EmailServiceImpl implements EmailSenderService {

	
	@Autowired
	JavaMailSender sender;
	
	
	
	@Override
	public void sendemail(EmailSender e) {
	
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(e.getTo());
		mail.setFrom(e.getFrom());
		mail.setSubject(e.getSubject());
		mail.setText(e.getTextBodyMsg());
		
		sender.send(mail);
		System.out.println("sent");
		
		
		
	}



	@Override
	public void sendmailwithattachemnt(EmailSender emailSender, MultipartFile file) {
		
		MimeMessage mimeMessage=sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);
			
			helper.setTo(emailSender.getTo());
			helper.setFrom(emailSender.getFrom());
			helper.setSubject(emailSender.getSubject());
			helper.setText(emailSender.getTextBodyMsg());
			helper.addAttachment(file.getOriginalFilename(), file);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sender.send(mimeMessage);
	}

	

	
	
}
