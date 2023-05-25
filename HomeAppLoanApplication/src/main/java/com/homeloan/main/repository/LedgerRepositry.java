package com.homeloan.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeloan.main.retalitionalmodel.Ledger;

public interface LedgerRepositry extends JpaRepository<Ledger, Integer> {

}
