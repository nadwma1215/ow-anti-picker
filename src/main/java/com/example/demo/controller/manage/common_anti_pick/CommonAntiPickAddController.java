package com.example.demo.controller.manage.common_anti_pick;

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

import com.example.demo.entity.CommonAntiPick;
import com.example.demo.entity.Hero;
import com.example.demo.form.common_anti_pick.CommonAntiPickAddForm;
import com.example.demo.mapper.CommonAntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommonAntiPickAddController {

	private final HeroMapper heroMapper;
	private final CommonAntiPickMapper commonAntiPickMapper;
	private final Mapper dozer;

	/**
	 * 登録画面へ遷移する
	 * 
	 * @param model
	 * @param form
	 * @param heroId アンチピックを登録するヒーローID
	 * @param userDetails ログインユーザ情報
	 * @return
	 */
	@GetMapping({ "/manage/common-anti-pick/add", "/manage/common-anti-pick/add/{heroId}" })
	public String add(Model model, CommonAntiPickAddForm form,
			@PathVariable(name = "heroId", required = false) Integer heroId) {

		if (heroId != null) {
			// パスパラメータからヒーローIDを取得できればフォームにセット
			form.setHeroId(heroId);
		}

		List<Hero> heroList = heroMapper.findAll();
		
		model.addAttribute(heroList);
		model.addAttribute(form);

		return "manage/common_anti_pick/add";
	}

	@PostMapping("/manage/common-anti-pick/add")
	public String register(Model model, @ModelAttribute @Validated CommonAntiPickAddForm form, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			List<Hero> heroList = heroMapper.findAll();

			model.addAttribute(heroList);

			return "manage/common_anti_pick/add";
		}

		commonAntiPickMapper.save(dozer.map(form, CommonAntiPick.class));

		return "redirect:/manage/common-anti-pick";
	}

}
