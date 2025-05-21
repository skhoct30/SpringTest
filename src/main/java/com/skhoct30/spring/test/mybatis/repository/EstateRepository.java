package com.skhoct30.spring.test.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	
	public Estate selectEstate(@Param("id")int id);
	
	public Estate selectEstateRent(@Param("rent")int rentPrice);
}
