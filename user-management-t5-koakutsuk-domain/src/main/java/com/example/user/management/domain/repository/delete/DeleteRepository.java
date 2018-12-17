package com.example.user.management.domain.repository.delete;

import ANACONDA.Account;

public interface DeleteRepository {
	void delete(Account account);
	Account findOne(String userID);
}
