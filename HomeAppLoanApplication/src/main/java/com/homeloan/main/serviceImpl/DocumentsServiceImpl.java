package com.homeloan.main.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.homeloan.main.model.RelationalExecutive;
import com.homeloan.main.repository.DocumentsRepository;
import com.homeloan.main.service.DocumentsServiceI;
@Service
public class DocumentsServiceImpl implements DocumentsServiceI {
	
	@Autowired
	DocumentsRepository dr;

	@Override
	public RelationalExecutive saveData(RelationalExecutive re) {
		
		return dr.save(re);
	}

	@Override
	public Iterable getDocuments() {
		
		return dr.findAll();
	}

}
