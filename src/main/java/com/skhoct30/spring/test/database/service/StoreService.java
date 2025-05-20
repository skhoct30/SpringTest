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
	
	
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
	
	
}
