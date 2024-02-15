package com.example.demo.form.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserAddForm {
	
	@NotEmpty
	@Size(min=1, max=20)
	private String name;
	
	@NotEmpty
	@Size(min=1, max=255)
	private String password;

}
