package com.example.demo.form.hero;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ヒーロー追加 Form
 */
@Data
public class HeroAddForm {
	
	private int roleId;
	
	@NotEmpty
	@Size(max = 50)
	private String name;

}
