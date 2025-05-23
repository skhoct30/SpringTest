package com.skhoct30.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.mybatis.domain.Estate;
import com.skhoct30.spring.test.mybatis.service.EstateService;

@Controller
@RequestMapping("db/mybatis/estate")
public class EstateController {

	
	@Autowired
	private EstateService estateService;
	
	
	@ResponseBody
	@RequestMapping("/1")
	public Estate estate(@RequestParam("id")int id) {
		
		Estate estate = estateService.getEstate(id);
		return estate;
	}
	
	
	@ResponseBody // 웹에 json 문자열로 보내기 위한 것. 일단 알려줌. . .
	@RequestMapping("/2")
	public List<Estate> estateRent(@RequestParam("rent")int rentPrice) {
		
		List<Estate> estateRent = estateService.getEstateRent(rentPrice);
		
		return estateRent;
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<Estate> estateAreaAndPrice(
			@RequestParam("area")int area,
			@RequestParam("price")int price) {
		
		List<Estate> estateAreaAndPrice = estateService.getEstateAreaAndPrice(area, price);
		return estateAreaAndPrice;
	}
	
	
	
	// INSERT
	
	@RequestMapping("/insert/1")
	@ResponseBody
	public String realEstateCreate(@RequestParam("realtorId") int realtorId) {
		
//		int count = estateService.addRealEstate(3, "푸르지용 리버 303동 1104호", 89, "매매", 100000);
//		
//		return "실행결과 : " + count;
		
//		Estate estate = new Estate();
//		
//		estate.setAddress("샹떼빌리버 오피스텔 814호");
//		estate.setArea(45);
//		estate.setType("월세");
//		estate.setPrice(100000);
//		estate.setRentPrice(120);
//		
//		int count = estateService.addRealEstateByObject(estate);
//		
//		return "실행결과 : " + count;
		
		int count = estateService.addRealEstate(realtorId, "샹떼빌리버 오피스텔 814호", 45, "월세", 120);
		
		
		return "실행결과 : " + count;
		
		
	}
	
	
	
	
	
	
	
	
	@ResponseBody // String 으로 변환해서 실행결과 : count 로 나타내기 위해서 사용
	@RequestMapping("/update")
	public String updateRealEstate() {
		// id 가 22인 행의 type 을 전세로 바꾸고 price 를 70000으로 변경하세요
		// 전달받은 값으로 수정하는 것이 편할 것이다.
		int count = estateService.updateRealEstate(22, "전세", 70000);
		
		return "실행결과 : " + count;
	}
	
	
	
	
	// Delete
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int count = estateService.deleteRealEstate(id);
		
		return "삭제 성공 : " + count;
	}
	
	
	
	
	
	
	
	
	
	
}
