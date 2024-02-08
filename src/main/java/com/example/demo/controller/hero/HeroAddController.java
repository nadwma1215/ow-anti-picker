package com.example.demo.controller.hero;

import java.util.List;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Hero;
import com.example.demo.entity.Role;
import com.example.demo.form.hero.HeroAddForm;
import com.example.demo.mapper.HeroMapper;
import com.example.demo.mapper.RoleMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HeroAddController {
	
	private final HeroMapper heroMapper;
	private final RoleMapper roleMapper;
	private final Mapper dozer;
	
	/**
	 * 登録画面へ遷移する
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@GetMapping("/hero/add")
	public String add(Model model, HeroAddForm form) {
		
		List<Role> roleList = roleMapper.findAll();
		model.addAttribute(roleList);
		
		return "hero/add";
	}
	
	@PostMapping("/hero")
	public String register(Model model, @ModelAttribute @Validated HeroAddForm form, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){
            
            List<Role> roleList = roleMapper.findAll();
            model.addAttribute(roleList);
            
            return "hero/add";
        }

		heroMapper.save(dozer.map(form, Hero.class));
		
		return "redirect:/hero";
	}

}
