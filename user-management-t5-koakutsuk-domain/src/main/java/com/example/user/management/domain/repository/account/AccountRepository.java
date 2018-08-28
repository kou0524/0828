package com.example.user.management.domain.repository.account;

import com.example.user.management.domain.model.Account;


public interface AccountRepository {
	Account findOne(String userID);
	void create(Account account);
	//Account findUser(String UserName);
	
}