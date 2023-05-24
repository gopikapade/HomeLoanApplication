package com.homeloan.main.serviceImpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidApplication;
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
	public List<RelationalExecutive> getDocuments() {
		
		return dr.findAll();
	}

	@Override
	public RelationalExecutive updateStatus(RelationalExecutive re) {
	
	        Optional<RelationalExecutive> findById = dr.findById(re.getReId());
	    
	 if(findById.isPresent()) {
		    RelationalExecutive relationalExecutive = findById.get();
		    re.setReId(relationalExecutive.getReId());
		    re.setStatus2(true);
		    return dr.save(re);
		    
	 }
	 else {
		 throw new InvalidApplication("Invalid Application request");
	 }
	
	}

	@Override
	public RelationalExecutive updateReamrk(RelationalExecutive re, String msg) {
		  
     Optional<RelationalExecutive> findById = dr.findById(re.getReId());
     
     if(findById.isPresent())
     {
          RelationalExecutive relationalExecutive = findById.get();	  
                              relationalExecutive.setRemark(msg);
                       return   dr.save(relationalExecutive);                             
     }
		
     else {
    	   throw new InvalidApplication("Invalid Application");
     }
	}

}
