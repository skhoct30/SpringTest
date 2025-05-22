package com.skhoct30.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.mybatis.domain.Estate;
import com.skhoct30.spring.test.mybatis.repository.EstateRepository;

@Service
public class EstateService {
	
	@Autowired
	private EstateRepository estateRepository;
	
	
	 public Estate getEstate(int id) {
		 
		 Estate estate = estateRepository.selectEstate(id);
		 
		 return estate;
	 }
	 
	 
	 public List<Estate> getEstateRent(int rentPrice) {
		 
		 List<Estate> estateRent = estateRepository.selectEstateRent(rentPrice);
		 
		 return estateRent;
		 
	 }
	 
	 public List<Estate> getEstateAreaAndPrice(int area, int price) {
		 
		 List<Estate> estateAreaAndPrice = estateRepository.selectEstateAreaAndPirce(area, price);
		 return estateAreaAndPrice;
		 
	 }
	 
}
