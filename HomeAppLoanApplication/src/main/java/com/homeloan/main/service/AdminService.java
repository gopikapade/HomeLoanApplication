package com.homeloan.main.service;

import com.homeloan.main.utility.Roles;

public interface AdminService {

	Roles addroles(Roles role);

	Roles findByUsernameandPassword(String username, String password);
	
}
