package com.example.demo.controller.anti_pick;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.HeroWithAntiPickDTO;
import com.example.demo.entity.AntiPick;
import com.example.demo.entity.Hero;
import com.example.demo.entity.UserDetailsImpl;
import com.example.demo.form.anti_pick.AntiPickListForm;
import com.example.demo.mapper.AntiPickMapper;
import com.example.demo.mapper.HeroMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AntiPickListController {
	
	private final HeroMapper heroMapper;
	private final AntiPickMapper antiPickMapper;
	
	@GetMapping("/anti-pick")
	public String index(Model model, AntiPickListForm form, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		
		List<Hero> heroList = heroMapper.findAll();
		List<HeroWithAntiPickDTO> heroWithAntiPickDTO = heroMapper.findByUserIdWithAntiPick(userDetails.getUser().getId());
		
		// listの初期化
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		// 取得したアンチピックをlistに格納
		heroWithAntiPickDTO.forEach(hero -> {
			// アンチヒーローIDのリストを作成
			List<Integer> listTmp = new ArrayList<>();
			hero.getAntiPickWithHeroDTOList().forEach(antiPick -> {
				listTmp.add(antiPick.getHeroId());
			});
			
			// アンチヒーローIDのリストをlistにset
			map.put(hero.getId(), listTmp);
		});
		
		// formにlistを格納
		form.setHeroIdMap(map);
		
		model.addAttribute(heroList);
		
		return "anti_pick/list";
	}
	
	@PostMapping("/anti-pick")
	public String register(Model model, AntiPickListForm form, @AuthenticationPrincipal UserDetailsImpl userDetails) {
		
		// 登録するアンチピックのリストの初期化
		List<AntiPick> antiPickList = new ArrayList<>();
		
		// formに格納されたヒーローとアンチピックの組み合わせをantiPickTmpに格納し、antiPickListに登録していく
		form.getHeroIdMap().forEach((heroId, antiPickListTmp) -> {
			
			// antiPickListTmpに1件以上登録されている場合
			if(antiPickListTmp.size() > 0) {
				// ヒーローIDとアンチヒーローIDをsetしてListに追加
				antiPickListTmp.forEach(antiPickId -> {
					AntiPick antiPickTmp = new AntiPick();
					antiPickTmp.setUserId(userDetails.getUser().getId());
					antiPickTmp.setHeroId(heroId);
					antiPickTmp.setAntiHeroId(antiPickId);
					antiPickList.add(antiPickTmp);
				});
			}
		});
		
		antiPickMapper.saveAll(antiPickList);
		
		return "redirect:/anti-pick";
	}

}
