package com.skhoct30.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.database.domain.Store;
import com.skhoct30.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	// 가게 정보 얻어오기. 
	public List<Store> getStoreList() {
		// store 테이블의 모든 행 조회 해오기.
		// 근데 얘는 찾아올 수 없어서 또 요청해야한다.
		// repository 한테 달라고 해야함.
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
	
	
}
