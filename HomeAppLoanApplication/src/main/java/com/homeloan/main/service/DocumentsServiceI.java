package com.homeloan.main.service;

import com.homeloan.main.model.RelationalExecutive;

public interface DocumentsServiceI {

	public RelationalExecutive saveData(RelationalExecutive re1);

	public Iterable<RelationalExecutive> getDocuments();

	public RelationalExecutive updateStatus(RelationalExecutive re);

	public RelationalExecutive updateReamrk(RelationalExecutive re, String msg);



}