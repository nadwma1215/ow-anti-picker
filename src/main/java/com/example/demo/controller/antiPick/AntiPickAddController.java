package com.example.demo.controller.antiPick;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AntiPick;
import com.example.demo.entity.Hero;
import com.example.demo.form.anti_pick.AntiPickAddForm;
import com.example.demo.mapper.AntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AntiPickAddController {
	
	private final HeroMapper heroMapper;
	private final AntiPickMapper antiPickMapper;
	private final Mapper dozer;
	
	/**
	 * 登録画面へ遷移する
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/anti-pick/add/{heroId}")
	public String add(Model model, AntiPickAddForm form, @PathVariable("heroId") Integer heroId) {
		
		form.setHeroId(heroId);
		
		List<Hero> heroList = heroMapper.findAll();
		model.addAttribute(heroList);
		model.addAttribute(form);
		
		return "anti_pick/add";
	}
	
	@PostMapping("/anti-pick")
	public String register(Model model, @ModelAttribute @Validated AntiPickAddForm form, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){
            
			List<Hero> heroList = heroMapper.findAll();
            model.addAttribute(heroList);
            
            return "anti_pick/add";
        }

		antiPickMapper.save(dozer.map(form, AntiPick.class));
		
		return "redirect:/anti-pick";
	}

}
