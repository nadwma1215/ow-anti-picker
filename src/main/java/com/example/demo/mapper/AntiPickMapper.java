package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.AntiPickWithHeroDTO;
import com.example.demo.entity.AntiPick;

@Mapper
public interface AntiPickMapper {

	public List<AntiPickWithHeroDTO> findByUserIdWithHero(@Param("userId") int userId);

	public int save(AntiPick antiPick);
	
	public void saveAll(List<AntiPick> antiPickList); 

}
