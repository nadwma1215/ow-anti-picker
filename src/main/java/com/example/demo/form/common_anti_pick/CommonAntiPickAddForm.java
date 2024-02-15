package com.example.demo.form.common_anti_pick;



import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * ヒーロー追加 Form
 */
@Data
public class CommonAntiPickAddForm {
	
	@NotNull
	private int heroId;
	
	@NotNull
	private int antiHeroId;
	
	private String reason;

}
