package com.example.demo.controller.anti_pick;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.AntiPickWithHeroDTO;
import com.example.demo.entity.Hero;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.mapper.AntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AntiPickListController {
	
	private final HeroMapper heroMapper;
	private final AntiPickMapper antiPickMapper;
	
	@GetMapping("/anti-pick")
	public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		
		List<Hero> heroList = heroMapper.findAll();
		List<AntiPickWithHeroDTO> AntiPickWithHeroDTOList = antiPickMapper.findByUserIdWithHero(userDetails.getUser().getId());
		
		model.addAttribute(heroList);
		model.addAttribute("AntiPickWithHeroDTOList", AntiPickWithHeroDTOList);
		
		return "anti_pick/list";
	}

}
