package com.homeloan.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.homeloan.main.model.EmailSender;

public interface EmailSenderService {

	public void sendemail(EmailSender e);

	public void sendmailwithattachemnt(EmailSender emailSender, MultipartFile file);

}
