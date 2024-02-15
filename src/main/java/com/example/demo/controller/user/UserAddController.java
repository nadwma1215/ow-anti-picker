package com.example.demo.controller.user;

import org.dozer.Mapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.user.UserAddForm;
import com.example.demo.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserAddController {

	private final UserMapper mapper;
	private final Mapper dozer;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/user/add")
	public String add(UserAddForm userAddForm) {
		return "user/add";
	}

	@PostMapping("/user/add")
	public String register(Model model, @ModelAttribute @Validated UserAddForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "user/add";
		}

		form.setPassword(passwordEncoder.encode(form.getPassword()));

		mapper.save(dozer.map(form, User.class));

		return "redirect:/login";
	}
}
