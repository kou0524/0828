package com.example.user.management.app.top;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.user.management.domain.model.Account;
import com.example.user.management.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping(value="top",method = { RequestMethod.GET })
public class TopController {
	@RequestMapping
	public String viewTopMenu( @AuthenticationPrincipal SampleUserDetails userDetails, // (1)
            Model model) {
        // (2)
        Account account = userDetails.getAccount();
        model.addAttribute(account);
		return "top/menu";
	}
}
