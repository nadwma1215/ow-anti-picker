package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.HeroWithAntiPickDTO;
import com.example.demo.dto.HeroWithCommonAntiPickDTO;
import com.example.demo.entity.Hero;

@Mapper
public interface HeroMapper {
	
	public List<Hero> findAll();
	
	public List<HeroWithAntiPickDTO> findByUserIdWithAntiPick(@Param("userId") int userId);

	public List<HeroWithCommonAntiPickDTO> findAllWithCommonAntiPick();
	
	public int save(Hero hero);

}
