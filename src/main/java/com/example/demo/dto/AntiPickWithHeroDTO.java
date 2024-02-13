package com.example.demo.dto;

import com.example.demo.entity.AntiPick;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * アンチピック Entity
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class AntiPickWithHeroDTO extends AntiPick{
	
	/**
	 * ヒーロー名
	 */
	private String HeroName;
	
	/**
	 * ヒーローの画像名
	 */
	private String HeroImageName;
	
	/**
	 * アンチピックのヒーロー名
	 */
	private String AntiHeroName;
	
	/**
	 * アンチピックのヒーローの画像名
	 */
	private String AntiHeroImageName;

}
