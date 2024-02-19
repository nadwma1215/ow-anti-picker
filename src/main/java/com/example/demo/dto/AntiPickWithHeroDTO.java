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
	private String heroName;
	
	/**
	 * ヒーローの画像名
	 */
	private String heroImageName;
	
	/**
	 * アンチピックのヒーローID
	 */
	private int antiHeroId;
	
	/**
	 * アンチピックのヒーロー名
	 */
	private String antiHeroName;
	
	/**
	 * アンチピックのヒーローの画像名
	 */
	private String antiHeroImageName;

}
