package com.homeloan.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.utility.Menues;
import com.homeloan.main.utility.Roles;

public interface MenuesRepository extends JpaRepository<Roles, Integer> 
{

	Optional<Roles> findByUsernameAndPassword(String username, String password);
	
}
