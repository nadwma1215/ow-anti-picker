package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.HeroWithAntiPickDTO;
import com.example.demo.entity.Hero;

@Mapper
public interface HeroMapper {
	
	public List<Hero> findAll();
	
	public List<HeroWithAntiPickDTO> findAllWithAntiPick();
	
	public int save(Hero hero);

}
