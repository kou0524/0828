package com.example.user.management.app.account;

import java.util.*;
import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import com.example.user.management.app.account.AccountCreateForm;
import com.example.user.management.app.account.IllegalOperationException;
import com.example.user.management.app.validation.PasswordEqualsValidator;
import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.model.Role;
import com.example.user.management.domain.service.account.AccountService;

@Controller
@SessionAttributes(value = { "accountCreateForm" })
@RequestMapping("user/register")
public class AccountCreateController {
	
	//相関チェックを行う Validator を Inject する。
	@Inject
	PasswordEqualsValidator passwordEqualsValidator; 

	@Inject
	AccountService accountService;

	@Inject
	Mapper beanMapper;
	//Inject した Validator を WebDataBinder に追加する。
	//WebDataBinder に追加しておくことで、入力チェック処理にて、Validator が実行され、相関チェックを行うことが出来る。
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(passwordEqualsValidator); 
	}
	@InitBinder
	public void initBinder1(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}


	@ModelAttribute(value = "accountCreateForm")
	public AccountCreateForm setUpAccountForm() {
		return new AccountCreateForm();
	}

	@RequestMapping(method = { RequestMethod.GET },params = "form")
	public String showCreateForm() {
		return "user/registerForm";
	}

	@RequestMapping(method = { RequestMethod.POST }, params = "confirm")
	public String confirmCreate(@Validated AccountCreateForm form,
			BindingResult result) {
		//入力チェックで間違いあった場合、登録フォームに戻る。
		if (result.hasErrors()) {
			return "user/registerForm";
		}

		return "user/registerConfirm";
	}

	@RequestMapping( method = RequestMethod.POST, params = "finish")
	public String update(@Validated AccountCreateForm form, BindingResult result) {
		//入力チェックで間違いあった場合、エラーメッセージ出力
		if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("e.st.ac.5001");
			throw new IllegalOperationException(messages);
		}

		Account account = beanMapper.map(form, Account.class);
		Role role = beanMapper.map(form, Role.class);
		//ここを、2つに分けて登録することを直す。
		accountService.create(account, form.getPassword(),role);

		return "user/registerFinish";
	}

}
