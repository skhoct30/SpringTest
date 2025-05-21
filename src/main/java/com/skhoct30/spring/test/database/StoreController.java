package com.skhoct30.spring.test.database;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.database.domain.Store;
import com.skhoct30.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		// Controller 는 서비스를 얻어오기 위한 기능. 
		// 서비스 패키지 >> 서비스 클래스 작성
		List<Store> storeList = storeService.getStoreList();
		
		
		return storeList;
	}
}
