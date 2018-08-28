package com.example.user.management.domain.service.account;

import java.util.ArrayList;

import javax.inject.Inject;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.model.Role;
import com.example.user.management.domain.repository.account.AccountRepository;
import com.example.user.management.domain.repository.userrole.RoleRepository;

@Service
public class AccountService {
	@Inject
	AccountRepository accountRepository;

	@Inject
	PasswordEncoder passwordEncoder;
	
	
	@Inject
	RoleRepository RoleRepository;
	
	public void create(Account account, String password,Role role) {
		account.setState("ACTV");
		account.setPassword(passwordEncoder.encode(password));
		accountRepository.create(account);
		
		//登録する権限内容を取得して、リストに格納（ADMN　USER　AMDN/USER）
		ArrayList<String> roles = role.getRoles();

		for (String userRole : roles) {
			//ユーザ権限をセッタ－で登録
			role.setRole(userRole);
			//ユーザ権限をDBに登録
			RoleRepository.createRole(role);
		}
		
	}
}
