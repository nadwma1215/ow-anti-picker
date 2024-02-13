package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.AntiPick;

@Mapper
public interface AntiPickMapper {
	
	public List<AntiPick> findAll();
	
	public List<AntiPick> findAllWithHeroName();
	
	public int save(AntiPick antiPick);

}
