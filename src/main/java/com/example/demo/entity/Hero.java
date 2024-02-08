package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * キャラクター Entity
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class Hero extends AbstractEntity{
	
	private int id;
	
	private int roleId;
	
	/**
	 * 紐づく画像のファイル名
	 */
	private String image_name;
	
	private String name;

}
