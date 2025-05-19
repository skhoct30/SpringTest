package com.skhoct30.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	
	public List<Map<String, Object>> mapRequest() {
		
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movieInfo = new HashMap<>();
		
		movieInfo.put("rate", 15);
		movieInfo.put("director", "봉준호");
		movieInfo.put("time", 131);
		movieInfo.put("title", " 기생충");
		
		movieInfo = new HashMap<>();
		
	}
	
	

}
