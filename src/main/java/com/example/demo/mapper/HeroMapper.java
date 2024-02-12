package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Hero;

@Mapper
public interface HeroMapper {
	
	public List<Hero> findAll();
	
	public int save(Hero hero);

}
