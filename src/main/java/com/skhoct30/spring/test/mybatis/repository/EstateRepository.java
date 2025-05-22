package com.skhoct30.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.test.mybatis.domain.Estate;

@Mapper
public interface EstateRepository {
	
	public Estate selectEstate(@Param("id")int id);
	// List 쓴 이유는 단 하나만 찾는 것이 아니고 이 문제에서는
	// 입력받은 수 보다 낮은 월세들을 나타내는데 매물이 하나가 아니고 여러개일 수 있으니까 리스트에 담는다
	public List<Estate> selectEstateRent(@Param("rentPrice")int rentPrice);
	//                                        얘는 xml에서 쓰는 놈
	
	public List<Estate> selectEstateAreaAndPirce(
			@Param("area") int area,
			@Param("price") int price);
	
	// insert
	
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price);
	
	
	public int insertRealEstateByObject(Estate estate);
	
}

