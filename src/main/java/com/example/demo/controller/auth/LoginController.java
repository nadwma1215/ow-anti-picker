package com.example.demo.controller.auth;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LoginController {
	
	private final HttpSession session;
	
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping(value = "/login", params = "error")
	public String loginWithError(Model model) {
		var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg", errorInfo.getMessage());
		return "auth/login";
	}
}
