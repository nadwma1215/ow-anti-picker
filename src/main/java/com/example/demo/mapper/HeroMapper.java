package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Hero;

@Mapper
public interface HeroMapper {
	
	@MapKey("id")
	public Map<Integer, Hero> findAll();
	
	public int save(Hero hero);

}
