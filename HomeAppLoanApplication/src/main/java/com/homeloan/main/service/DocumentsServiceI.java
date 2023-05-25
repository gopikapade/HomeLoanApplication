package com.homeloan.main.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.homeloan.main.model.RelationalExecutive;

public interface DocumentsServiceI {

	public RelationalExecutive saveData(RelationalExecutive re1);

	public List<RelationalExecutive> getDocuments();

	public RelationalExecutive updateStatus(RelationalExecutive re);

	public RelationalExecutive updateReamrk(RelationalExecutive re, String msg);

	public RelationalExecutive saveCMSanctionLetter(RelationalExecutive rx, byte[] readAllBytes);
	
	
	public RelationalExecutive updateDoc( String relexe, MultipartFile addressProof, MultipartFile pancard,
			MultipartFile incomeTax, MultipartFile aadharCard, MultipartFile photo, MultipartFile salarySlip,
			MultipartFile buildingpermission, MultipartFile layout, MultipartFile buildingPlan, MultipartFile estimate,
			MultipartFile noc) throws IOException, IOException;

	public List<RelationalExecutive> getSanctionLeeters();

	public RelationalExecutive forwordToAh(Integer id);
}
