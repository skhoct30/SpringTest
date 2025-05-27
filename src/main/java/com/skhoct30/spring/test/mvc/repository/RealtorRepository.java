package com.skhoct30.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {
	
	// 행을 추가하는거라서 인설트
	// 프라이머리key 를 얻어오기 위한 방법
	public int insertRealtor(Realtor realtor);
}
