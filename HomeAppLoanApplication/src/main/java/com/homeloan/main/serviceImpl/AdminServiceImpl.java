package com.homeloan.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeloan.main.exception.InvalidLoginException;
import com.homeloan.main.repository.MenuesRepository;
import com.homeloan.main.service.AdminService;
import com.homeloan.main.utility.Roles;



@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	MenuesRepository menuesRepository;
	
	
	@Override
	public Roles addroles(Roles role) {
		return menuesRepository.save(role);
	}


	@Override
	public Roles findByUsernameandPassword(String username, String password) {
	    
		Optional<Roles> findRole = menuesRepository.findByUsernameAndPassword(username, password);
		

		if(findRole.isPresent())
		{
			 return findRole.get();
		}
		else {
			throw new InvalidLoginException("Please provide valid Username and Password");
		}
		
	
	}

}
