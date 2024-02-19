package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * アンチピック Entity
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class AntiPick extends AbstractEntity{
	
	private int id;
	
	private int antiPickHistoryId;
	
	private int heroId;
	
	private int antiHeroId;
	
	private String reason;

}
