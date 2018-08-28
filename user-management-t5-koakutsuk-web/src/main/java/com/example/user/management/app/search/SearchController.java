package com.example.user.management.app.search;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.user.management.app.validation.PhoneNumberValidator;
import com.example.user.management.app.validation.UserIDValidator;
import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.model.SearchCriteria;
import com.example.user.management.domain.service.search.SearchSharedService;


@Controller
@SessionAttributes(value = { "searchForm" })
@RequestMapping("user")
public class SearchController {

	//データの受け渡しをする場合など、Beanマッピングが必要となるケースは多い。（ドメイン層⇔アプリケーション層など）
	@Inject
	Mapper beanMapper;

	@Inject
	SearchCriteria searchcriteria;

	@Inject
	SearchSharedService searchSharedService;

	//userIDの入力チェックを行うための validatorの挿入
	@Inject
	UserIDValidator userIDValidator;

	//電話番号の入力チェックを行うための validatorの挿入
	@Inject
	PhoneNumberValidator phoneNumberValidator;

	/**inject した Validator を WebDataBinder に追加する。
	 * WebDataBinder に追加しておくことで、ハンドラメソッド（処理を行うメソッド）呼び出し前に行われる入力
チェック処理にて、追加した Validator が実行され、相関チェックを行うことが出来る。
	 **/
	//作成したvalidatorで入力チェックが行われる。
	@InitBinder("searchForm")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userIDValidator);
		binder.addValidators(phoneNumberValidator);
	}

	/**検索処理を行う**/
	@ModelAttribute(value = "searchForm")
	public SearchForm setUpSearch() {
		return new SearchForm();

	}
	/**検索画面の表示**/
	@RequestMapping(value = "search",method = { RequestMethod.GET }, params = "form")
	public String viewSearchForm() {
		return "user/searchForm";
	}

	/**通常の個別検索**/
	//Springが用意するMapオブジェクトで、Viewに渡すオブジェクトを設定します。
	@RequestMapping(value = "search",method = {RequestMethod.POST}, params = "confirm")
	String searchList(@Validated SearchForm form,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "user/searchForm";
		}

		Account account = beanMapper.map(form,Account.class);
		//ページ番号はデフォルトの1ページ目を指定している。
		searchcriteria.setPage(0);
		//1ページで取得する件数の指定　ここでは3件としている。
		Pageable pageable = new PageRequest(searchcriteria.getPage(), 3);

		return searchList(account, pageable, model);
	}

	/**ページが変更された時の商品一覧画面表示処理を行う。**/
	@RequestMapping(value = "search")
	String changePage(@Validated SearchForm form, Pageable pageable, Model model) {
		Account account = beanMapper.map(form, Account.class);
		searchcriteria.setPage(pageable.getPageNumber());
		return searchList(account, pageable, model);
	}
	
	/**共通部分を扱う。pageableをもとに商品を検索する。**/
	String searchList(Account account, Pageable pageable, Model model) {
		Page<Account> page = searchSharedService.findUser(account, pageable);
		model.addAttribute("page", page);
		return "user/searchList";
	}

}