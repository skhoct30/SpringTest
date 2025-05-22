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
	
	@RequestMapping("/3")
	public List<Estate> estateAreaAndPrice(
			@RequestParam("area")int area,
			@RequestParam("price")int price) {
		
		List<Estate> estateAreaAndPrice = estateService.getEstateAreaAndPrice(area, price);
		return estateAreaAndPrice;
	}
	
	
	
	
	
	
}
