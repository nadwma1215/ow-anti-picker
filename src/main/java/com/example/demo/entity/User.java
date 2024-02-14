package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class User extends AbstractEntity {

	private int id;
	
	private String name;

	private String password;

}
