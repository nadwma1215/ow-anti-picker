package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ロール Entity
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class Role extends AbstractEntity{
	
	private int id;
	
	private String name;

}
