package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.model.RelationalExecutive;

public interface DocumentsRepository extends JpaRepository<RelationalExecutive, Integer> {

}
