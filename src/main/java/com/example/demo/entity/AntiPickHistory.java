package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * アンチピック Entity
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AntiPickHistory extends AbstractEntity {

	private int id;

	private int userId;
	
}
