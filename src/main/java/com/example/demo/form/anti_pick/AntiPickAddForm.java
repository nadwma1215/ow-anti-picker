package com.example.demo.form.anti_pick;



import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ヒーロー追加 Form
 */
@Data
public class AntiPickAddForm {
	
	@NotNull
	private int heroId;
	
	@NotNull
	private int antiHeroId;
	
	private String reason;

}
