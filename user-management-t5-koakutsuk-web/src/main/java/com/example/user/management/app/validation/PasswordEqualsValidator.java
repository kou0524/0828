package com.example.user.management.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.example.user.management.app.account.AccountCreateForm;
@Component 
public class PasswordEqualsValidator implements Validator {
	
	//AccountCreateFormをvalidatorのチェック対象に登録する。
	@Override
	public boolean supports(Class<?> clazz) {
		return AccountCreateForm.class.isAssignableFrom(clazz); // (2)
	}
	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasFieldErrors("password")) { // 単項目チェック時に対象フィールドでエラーが発生している場合は、この Validator で相関チェックは行わない。
			return;
		}
		AccountCreateForm form = (AccountCreateForm) target;
		String password = form.getPassword();
		String confirmPassword = form.getConfirmPassword();
		//チェックロジックの実装
		if (!password.equals(confirmPassword)) { 
			errors.rejectValue(/* エラー対象のフィールド名を指定する。 */ "password",
					/* (6) */ "PasswordEqualsValidator.passwordResetForm.password",
					/* (7) */ "password and confirm password must be same.");
		}
	}
}
