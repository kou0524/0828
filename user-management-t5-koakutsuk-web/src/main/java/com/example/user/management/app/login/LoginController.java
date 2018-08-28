package com.example.user.management.app.login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "loginForm" ,method = RequestMethod.GET)
	public String viewLoginForm() {
		return "login/loginForm";
	}

}