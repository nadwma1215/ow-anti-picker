package com.example.demo.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.AntiPick;

@Mapper
public interface AntiPickMapper {
	
	@MapKey("id")
	public Map<Integer, AntiPick> findAll();
	
	public int save(AntiPick antiPick);

}
