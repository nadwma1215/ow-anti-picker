package com.example.demo.controller.manage.common_anti_pick;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.CommonAntiPickWithHeroDTO;
import com.example.demo.entity.Hero;
import com.example.demo.mapper.CommonAntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommonAntiPickListController {
	
	private final HeroMapper heroMapper;
	private final CommonAntiPickMapper commonAntiPickMapper;
	
	@GetMapping("/manage/common-anti-pick")
	public String index(Model model) {
		
		List<Hero> heroList = heroMapper.findAll();
		List<CommonAntiPickWithHeroDTO> commonAntiPickWithHeroDTOList = commonAntiPickMapper.findAllWithHero();
		
		model.addAttribute(heroList);
		model.addAttribute("commonAntiPickWithHeroDTOList", commonAntiPickWithHeroDTOList);
		
		return "manage/common_anti_pick/list";
	}

}
