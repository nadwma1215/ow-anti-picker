package com.example.demo.controller.manage.hero;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Hero;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HeroListController {

	private final HeroMapper mapper;

	@GetMapping("/manage/hero")
	public String index(Model model) {

		List<Hero> heroList = mapper.findAll();

		model.addAttribute(heroList);

		return "manage/hero/list";
	}

}
