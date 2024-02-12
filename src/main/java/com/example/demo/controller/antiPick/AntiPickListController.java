package com.example.demo.controller.antiPick;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.AntiPick;
import com.example.demo.entity.Hero;
import com.example.demo.mapper.AntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AntiPickListController {
	
	private final HeroMapper heroMapper;
	private final AntiPickMapper antiPickMapper;
	
	@GetMapping("/anti-pick")
	public String index(Model model) {
		
		List<Hero> heroList = heroMapper.findAll();
		List<AntiPick> antiPickList = antiPickMapper.findAll();
		
		model.addAttribute(heroList);
		model.addAttribute(antiPickList);
		
		return "anti_pick/list";
	}

}
