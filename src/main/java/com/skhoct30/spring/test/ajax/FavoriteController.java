package com.skhoct30.spring.test.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.skhoct30.spring.test.ajax.domain.Favorite;
import com.skhoct30.spring.test.ajax.service.FavoriteService;

@Controller
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favorite = favoriteService.getFavorite();
		
		
		model.addAttribute("Favorite", favorite);
		
		return "ajax/input"; // 이거 인풋에서 다른걸로 바꿔야함 일단 대체로 작성 
		
	}
	
	
}
