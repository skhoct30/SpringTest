package com.skhoct30.spring.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.ajax.domain.Favorite;
import com.skhoct30.spring.test.ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	// view 테이블 ( 웹에 리스트를 보여지게끔 만들어지는 기능 )
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavorite();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "ajax/favorite/list";
	}
	
	
	// 즐겨찾기 추가 API
	@ResponseBody //얘를 쓴 이유 json 문자열로 확인하기 위해서
	@PostMapping("/create")
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		//응답을 구성하는 과정
		// 데이터를 응답에 담는다 = API
		
		// JSON
		// 성공 : {"result":"succes"}
		// 실패 : {"result":"fail"}
		// 이거 사용법 아니고 이런형태로 데이터를 담아줘서 확인을 하는 방법이다. 라고 알고 있으면됨.
		
		Map<String, String> resultMap = new HashMap<>();
		
		// 여기서 실행되는 개수는 1 실패는 0 이라고 떠야한다 위에 int count 로 정했으니까( 1이 되는 이유는 1개의 정보가 추가되서 1 ) 
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	
	@GetMapping("/input")
	public String inputFavorite() {
		return "ajax/favorite/input";
	}
	
	
	
	// 이메일 중복확인
	@GetMapping("/duplicate-url")
	@ResponseBody
	public Map<String, Boolean> inDuplicateUrl(@RequestParam("url")String url) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		if(favoriteService.isDuplicate(url)) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		
		return resultMap;
	}
	
	
	
	
}
