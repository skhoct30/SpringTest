package com.skhoct30.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.test.database.domain.Store;

@Mapper
public interface StoreRepository {
	
	public List<Store> selectStoreList();
	
}
