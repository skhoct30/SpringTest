package com.skhoct30.spring.test.mybatis.service;

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
	 
	 
	 public Estate getEstateRent(int rentPrice) {
		 
		 Estate estateRent = estateRepository.selectEstateRent(rentPrice);
		 
		 return estateRent;
		 
	 }
	 
	 
	 
}
