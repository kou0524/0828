package com.example.user.management.domain.service.delete;

import java.sql.Timestamp;

import ANACONDA.Account;

public interface DeleteService {
	void delete(Account account);
	Account findOne(String userID);
}
