package com.example.user.management.domain.repository.search;

import java.util.List;

import org.apache.ibatis.session.RowBounds;


import com.example.user.management.domain.model.Account;

//インタフェースのみ定義する。データアクセスなどの実装は行わない。searchsharedoserviceとがったいさせても問題ない？
public interface SearchRepository {

	//	検索条件に一致するEntityの総件数を取得するメソッドを定義する。
	long countByCriteria(Account account);
	//	 検索条件に一致するEntityの中から、取得範囲のEntityを抽出するメソッドを定義する。
	//	定義したメソッドの引数として、取得範囲の情報(offsetとlimit)を保持するRowBoundsを指定する。
	List<Account> findUser(Account account,
			RowBounds rowBounds);

}