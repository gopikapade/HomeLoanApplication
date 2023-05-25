package com.homeloan.main.service;

import com.homeloan.main.retalitionalmodel.AccountDetails;

public interface AccountService {

	public AccountDetails updateaccountservice(Integer id, AccountDetails accountdetails);

	public Iterable<AccountDetails> getalldata();

}
