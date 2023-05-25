package com.homeloan.main.service;

import com.homeloan.main.retalitionalmodel.Ledger;

public interface LedgerService {

	public Ledger ledgerupdate(Integer id, Ledger accountdetails);

	public Iterable<Ledger> getledgerdata();



}
