package com.example.user.management.domain.service.search;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ANACONDA.Account;


public interface SearchSharedService {
//	動的条件に一致する Entity の中から指定ページに該当する Entity を取得するメソッドを実装する。
	Page<Account> findUser(Account account,Pageable pageable);
}

