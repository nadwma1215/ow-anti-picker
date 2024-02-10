package com.example.demo.controller.hero;

import java.util.Map;

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
	
	@GetMapping("/hero")
	public String index(Model model) {
		
		Map<Integer, Hero> heroMap = mapper.findAll();
		model.addAttribute("heroMap", heroMap);
		
		return "hero/list";
	}

}
