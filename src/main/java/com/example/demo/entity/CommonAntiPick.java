package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 共通アンチピック Entity
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class CommonAntiPick extends AbstractEntity{
	
	private int id;
	
	private int heroId;
	
	private int antiHeroId;
	
	private String reason;

}
