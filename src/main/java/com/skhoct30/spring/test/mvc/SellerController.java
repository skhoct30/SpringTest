package com.skhoct30.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.mvc.domain.Seller;
import com.skhoct30.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	
	@Autowired
	private SellerService sellerService;
	
	
	// 하나의 판매자 정보 저장 기능
	// 닉네임, 매너온도, 프로필
	
	
//	@ResponseBody
//	@RequestMapping(path="/mvc/seller/creat", method=RequestMethod.POST) 이거는 코드가 좀 기니까 아래 방법으로 진행
	@PostMapping("/create")
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage
			) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
//		return "실행 결과 : " + count;
		return "redirect:/mvc/seller/info";
		
	}
	
	@GetMapping("/input") // 요청처리하는 컨트롤러 만들고 그 링크를 string 문자열로 리턴
	// GetMapping 은 url 주소에 넣는것이고 아래 return 값은 파일안에 있는 경로
	public String sellerInput() {
		
		return "mvc/seller/input";
	}
	
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		Seller seller = null;
		if(id == null) {
			seller = sellerService.getLastSeller(); // 2번문제에서 사용한 코드 / 가장최근에 등록한 놈
		} else {
			seller = sellerService.getSeller(id);	
		}
		

		model.addAttribute("seller", seller);
		
		return "mvc/seller/info";
	}
	
	
	
}
