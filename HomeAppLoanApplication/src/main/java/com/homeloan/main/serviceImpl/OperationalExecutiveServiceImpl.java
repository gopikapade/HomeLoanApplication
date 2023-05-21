package com.homeloan.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.model.OperationalExecutive;
import com.homeloan.main.repository.OperationalExecutiveRepository;
import com.homeloan.main.service.OperationalExecutiveServiceI;
@Service
public class OperationalExecutiveServiceImpl implements OperationalExecutiveServiceI {
	
	@Autowired
	OperationalExecutiveRepository oer;

	@Override
	public OperationalExecutive saveData(OperationalExecutive operationalExecutive) {
		
		return oer.save(operationalExecutive);
	}

	@Override
	public List<OperationalExecutive> getData() {
		
		return oer.findAll();
	}

}
