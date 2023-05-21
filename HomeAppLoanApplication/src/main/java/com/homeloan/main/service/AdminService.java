package com.homeloan.main.service;

import java.util.List;

import com.homeloan.main.utility.Roles;

public interface AdminService {

	Roles addroles(Roles role);

	Roles findByUsernameandPassword(String username, String password);

	List<Roles> getmenues();
	
}
