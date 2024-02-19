package com.example.demo.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.HeroWithAntiPickDTO;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyAntiPickController {

	private final HeroMapper heroMapper;

	@GetMapping("/my-anti-pick")
	public String myAntiPick(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

		List<HeroWithAntiPickDTO> heroWithAntiPickDTO = heroMapper.findByUserIdWithAntiPick(userDetails.getUser().getId());
		HeroWithAntiPickDTO.sort(heroWithAntiPickDTO);

		model.addAttribute("heroWithAntiPickDTO", heroWithAntiPickDTO);

		return "my-anti-pick";
	}

}
