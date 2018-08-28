package com.example.user.management.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.user.management.app.search.SearchForm;

@Component
public class PhoneNumberValidator implements Validator {

	//SearchFormをvalidatorのチェック対象に登録する。
	@Override
	public boolean supports(Class<?> clazz) {
		return SearchForm.class.isAssignableFrom(clazz); 
	}

	@Override
	public void validate(Object target, Errors errors) {
		SearchForm form = (SearchForm) target;
        String phoneNumber = form.getPhoneNumber();

        //空文字の場合はチェックしない。
        if ("".equals(phoneNumber)) {
        	return;
        }

        //桁数チェック(10桁もしくは、１１桁じゃなければエラーメッセージを表示)
        if ((phoneNumber.length()!= 10)&&(phoneNumber.length()!= 11)) {
            errors.rejectValue(
        		"phoneNumber",	//フィールド名
        		"phoneNumberValidator.SearchForm.phoneNumber",	//メッセージコード名
        		"電話番号は10桁か11桁で入力してください"	//デフォルトメッセージ
    		);
        }
	}

}
