package com.example.user.management.domain.service.search;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.repository.search.SearchRepository;
import com.example.user.management.domain.repository.userrole.RoleRepository;


@Service
public class SearchSharedServiceImpl implements SearchSharedService {
	@Inject
	SearchRepository searchRepository;

	@Inject
	RoleRepository roleRepository;



	@Transactional(readOnly=true)
	@Override
	public Page<Account> findUser(Account account,Pageable pageable) {
		//検索条件に一致する Entity の総件数を取得する
		long total = searchRepository.countByCriteria(account);

		List<Account> accountList;

		if (0 < total) {
			//ページネーション検索の取得範囲を指定する RowBounds オブジェクト
			RowBounds rowBounds = new RowBounds(pageable.getOffset(),
					pageable.getPageSize());
			//Repository のメソッドを呼び出し、検索条件に一致した取得範囲の Entity を取得する。ここなら、1ページにつき、3つだけ。
			accountList = searchRepository.findUser(account, rowBounds);
			} else {
			// (6)検索条件に一致する Entity が存在しない場合は、空のリストを検索結果に設定する。

				accountList = Collections.emptyList();
			}
		
		//ページ情報を作成して保持する。
		return new PageImpl<>(accountList, pageable, total);
	}
}
