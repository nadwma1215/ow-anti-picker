package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.HeroWithAntiPickDTO;
import com.example.demo.entity.AntiPick;
import com.example.demo.mapper.AntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TopController {

	private final HeroMapper heroMapper;
	private final AntiPickMapper antiPickMapper;

	@GetMapping("/")
	public String top(Model model) {

		List<HeroWithAntiPickDTO> heroListWithAntiPick = heroMapper.findAllWithAntiPick();
		HeroWithAntiPickDTO.sort(heroListWithAntiPick);
		
		List<AntiPick> antiPickList = antiPickMapper.findAll();

		model.addAttribute("heroListWithAntiPick", heroListWithAntiPick);
		model.addAttribute(antiPickList);

		return "top";
	}

}
