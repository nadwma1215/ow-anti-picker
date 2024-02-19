package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.AntiPickHistory;

@Mapper
public interface AntiPickHistoryMapper {

	public void save(AntiPickHistory antiPickHistory);

}
