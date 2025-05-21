package com.skhoct30.spring.test.mybatis;

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
	
	
	@ResponseBody
	@RequestMapping("/2")
	public Estate estateRent(@RequestParam("rent")int rentPrice) {
		
		Estate estateRent = estateService.getEstateRent(rentPrice);
		
		return estateRent;
	}
	
	
	
	
	
	
}
