package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.CommonAntiPickWithHeroDTO;
import com.example.demo.entity.CommonAntiPick;

@Mapper
public interface CommonAntiPickMapper {
	
	public List<CommonAntiPick> findAll();

	public List<CommonAntiPickWithHeroDTO> findAllWithHero();

	public int save(CommonAntiPick commonAntiPick);

}
