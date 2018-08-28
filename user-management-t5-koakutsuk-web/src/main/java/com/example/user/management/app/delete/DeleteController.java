package com.example.user.management.app.delete;


import java.sql.Timestamp;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;


import com.example.user.management.app.account.IllegalOperationException;
import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.service.delete.DeleteService;

@Controller
@RequestMapping("user")
@SessionAttributes(value = { "deleteForm" })
public class DeleteController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Inject
	DeleteService deleteService;
	
	@Inject
	Mapper beanMapper;

	// アカウント削除フォームインスタンスの作成
	@ModelAttribute(value = "deleteForm")
	public DeleteForm setUpAccountForm() {
		return new DeleteForm();
	}

	// ユーザ一覧画面からアカウント削除確認画面への遷移
	@RequestMapping(value = "delete", params = "userID", method = RequestMethod.GET)
	public String showDeleteForm(DeleteForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("アカウント検索処理時エラー");
			throw new IllegalOperationException(messages);
		}
		Account account = beanMapper.map(form, Account.class);
		account = deleteService.findOne(account.getUserID());

		model.addAttribute("account", account);
		return "user/deleteForm";
	}


	// 削除完了画面の表示
	@RequestMapping(value = "delete", method = RequestMethod.GET, params = "finish")
	public String finishDelete(DeleteForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			ResultMessages messages = ResultMessages.error();
			messages.add("アカウント削除処理時エラー");
			throw new IllegalOperationException(messages);
		}
		Account account = beanMapper.map(form, Account.class);
		deleteService.delete(account);

		model.addAttribute("account", account);
		
		return "user/deleteFinish";
	}
}
