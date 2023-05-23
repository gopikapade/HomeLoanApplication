package com.homeloan.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homeloan.main.responce.BaseResponse;
import com.homeloan.main.service.AdminService;
import com.homeloan.main.utility.Roles;


@CrossOrigin("*")
@RestController
@RequestMapping("menu")
public class MenuController {
  
@Autowired
AdminService service;
	
	@PostMapping("addmenu")
	private ResponseEntity<Roles> addMenus(@RequestBody Roles role){
		Roles savedroles =  service.addroles(role); 
		return new  ResponseEntity<Roles>(savedroles, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("admin/{username}/{password}")
	private  ResponseEntity<BaseResponse<Roles>> AdminLogin(@PathVariable String username, @PathVariable String password)
	{
		
		   Roles role  = service.findByUsernameandPassword(username, password);
		  
		   BaseResponse<Roles> baseResponse = new BaseResponse<Roles>(201, new Date(), "Loged in", role);
		
		   return new ResponseEntity<BaseResponse<Roles>>(baseResponse, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllMenues")
	private List<Roles> geRoles()
	{
		return  service.getmenues();
	}	
		
}
	
	  
