package com.example.user.management.app.validation;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.user.management.app.search.SearchForm;

@Component
public class UserIDValidator implements org.springframework.validation.Validator {

	//SearchFormをvalidatorのチェック対象に登録する。
	@Override
	public boolean supports(Class<?> clazz) {
		return SearchForm.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		SearchForm form = (SearchForm) target;
        String id = form.getUserID();

        //空文字の場合は、チェックは行わない。
        if ("".equals(id)) {
        	return;
        }

        //桁数チェック(４桁じゃない場合、エラーメッセージを表示する。)
        if (id.length()!=4) {
            errors.rejectValue(
        		"userID",	//フィールド名
        		"UserIDValidator.SearchForm.userID",	//メッセージコード名
        		"ユーザIDは4桁で入力してください"	//デフォルトメッセージ
    		);
        }
	}

}
