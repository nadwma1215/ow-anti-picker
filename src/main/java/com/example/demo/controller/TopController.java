package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.HeroWithCommonAntiPickDTO;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TopController {

	private final HeroMapper heroMapper;

	@GetMapping({ "top", "/" })
	public String top(Model model) {

		List<HeroWithCommonAntiPickDTO> heroListWithCommonAntiPick = heroMapper.findAllWithCommonAntiPick();
		HeroWithCommonAntiPickDTO.sort(heroListWithCommonAntiPick);

		model.addAttribute("heroListWithCommonAntiPick", heroListWithCommonAntiPick);

		return "top";
	}

}
