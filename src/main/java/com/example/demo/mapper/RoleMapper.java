package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Role;

@Mapper
public interface RoleMapper {
	
	public List<Role> findAll();

}
