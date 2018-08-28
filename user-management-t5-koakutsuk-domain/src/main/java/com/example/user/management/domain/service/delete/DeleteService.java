package com.example.user.management.domain.service.delete;

import java.sql.Timestamp;

import com.example.user.management.domain.model.Account;

public interface DeleteService {
	void delete(Account account);
	Account findOne(String userID);
}
