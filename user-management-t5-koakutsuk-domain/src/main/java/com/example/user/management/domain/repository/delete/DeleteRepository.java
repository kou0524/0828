package com.example.user.management.domain.repository.delete;

import com.example.user.management.domain.model.Account;

public interface DeleteRepository {
	void delete(Account account);
	Account findOne(String userID);
}
