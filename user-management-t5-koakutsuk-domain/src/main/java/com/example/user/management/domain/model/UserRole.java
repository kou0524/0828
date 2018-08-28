package com.example.user.management.domain.model;


import org.terasoluna.gfw.common.codelist.EnumCodeList;

//コードリストのラベルをEnumクラスで管理することで、 コード値に紐づく情報と操作をEnumクラスに集約する事ができる
//SimpleMapCodeListのように、xmlに記述しなくて良い。
public enum UserRole implements EnumCodeList.CodeListItem {

	//定数を定義する。
	ADMN("ADMN", "管理者"), USER("USER", "一般ユーザ");

	// コードリストを作成するために必要な情報(コード値とラベル)を保持するプロパティを用意する。
	private final String label;
	private final String value;

	// コードリストを作成するために必要な情報(コード値とラベル)を受け取るコンストラクタを用意する。
	private UserRole(String codeValue, String codeLabel) {
		this.label = codeLabel;
		this.value = codeValue;
	}

	@Override
	public String getCodeLabel() {
		return label;
	}

	@Override
	public String getCodeValue() {
		return value;
	}

}