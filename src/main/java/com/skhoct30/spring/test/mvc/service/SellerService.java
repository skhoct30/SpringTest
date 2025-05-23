package com.skhoct30.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.mvc.domain.Seller;
import com.skhoct30.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	
	public Seller addSeller(String nickname, String profileImage, double temperature) {
		
		Seller seller = sellerRepository.selectSeller(nickname, profileImage, temperature);
		
		return seller;
	}
}
