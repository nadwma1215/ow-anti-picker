package com.example.demo.controller.antiPick;

import java.util.Map;

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
		
		Map<Integer, Hero> heroMap = heroMapper.findAll();
		Map<Integer, AntiPick> antiPickMap = antiPickMapper.findAll();
		
		model.addAttribute("heroMap", heroMap);
		model.addAttribute("antiPickMap", antiPickMap);
		
		return "anti_pick/list";
	}

}
