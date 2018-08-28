package com.example.user.management.domain.model;

import org.terasoluna.gfw.common.codelist.EnumCodeList;

public enum UserState implements EnumCodeList.CodeListItem {
//定数を定義する。
	INIT("INIT", "初期状態"), ACTV("ACTV", "有効状態"), RMVD("RMVD", "削除済み");

	// コードリストを作成するために必要な情報(コード値とラベル)を保持するプロパティを用意する。
	private final String label;
	private final String value;

	// コードリストを作成するために必要な情報(コード値とラベル)を受け取るコンストラクタを用意する。
	private UserState(String codeValue, String codeLabel) {
		this.label = codeLabel;
		this.value = codeValue;
	}

	// (6)
	@Override
	public String getCodeLabel() {
		return label;
	}

	@Override
	public String getCodeValue() {
		return value;
	}

}