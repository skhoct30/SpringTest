package com.skhoct30.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.mvc.domain.Seller;
import com.skhoct30.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	
	public int addSeller(String nickname, double temperature, String profileImage) {
			
		int count = sellerRepository.insertSeller(nickname, temperature, profileImage);
		
		return count;
	}
	
	
	
	
	
	// 2번
	// 가장 최근에 등록한 사용자 정보
	
	public Seller getLastSeller() {
		
		Seller seller = sellerRepository.selectLastSeller();
		
		return seller;
	}
	
	
	// 3번
	
	public Seller getSeller(int id) {
		
		Seller seller = sellerRepository.selectSeller(id);
		
		return seller;
	}
	
	
	
}

