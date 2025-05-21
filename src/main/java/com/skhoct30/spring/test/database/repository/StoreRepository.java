package com.skhoct30.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	//여기서도 호출하는 식으로 불러야하기 때문에 
	// 여기서는 mapper >> 로 보내야함.
	public List<Store> selectStoreList();
	
}
