package com.skhoct30.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {
	
	
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature") double temperature
			, @Param("profileImage") String profileImage);
	
	
	// 2번
	// 가장 최근에 등록된 행의 정보
	
	public Seller selectLastSeller();
	
	
	// 3번
	public Seller selectSeller(@Param("id") int id);
	
}
