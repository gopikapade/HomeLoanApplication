package com.homeloan.main.service;

import java.util.List;

import com.homeloan.main.model.RelationalExecutive;

public interface DocumentsServiceI {

	public RelationalExecutive saveData(RelationalExecutive re1);

	public List<RelationalExecutive> getDocuments();

	public RelationalExecutive updateStatus(RelationalExecutive re);

	public RelationalExecutive updateReamrk(RelationalExecutive re, String msg);

	public RelationalExecutive saveCMSanctionLetter(RelationalExecutive rx, byte[] readAllBytes);
	



}
