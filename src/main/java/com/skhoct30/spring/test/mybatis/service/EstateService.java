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
	 
	 
	 // INSERT
	 
	 public int addRealEstate(int realtorId
			 , String address
			 , int area
			 , String type
			 , int price) {
		 
		 int count = estateRepository.insertRealEstate(realtorId, address, area, type, price);
		 return count;
	 }
	 
	 public int addRealEstateByObject(Estate estate) {
		 
		 int count = estateRepository.insertRealEstateByObject(estate);
		 return count;
	 }
	 
	 
	 // update
	 // 전달받은 id와 일치하는 매물의 정보의 type 과 price 를 수정하는 기능
	 
	 
	 
	 public int updateRealEstate(int id, String type, int price) {
		 
		 int count = estateRepository.updateRealEstate(id, type, price);
		 
		 return count;
	 }
	 
	 
	 
	 // delete
	 // 특정한 매물 을 삭제하자 >> id 값으로 찾아서 삭제하자
	 
	 public int deleteRealEstate(int id) {
		 
		 int count = estateRepository.deleteRealEstate(id);
		 
		 return count;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
