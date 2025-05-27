package com.skhoct30.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skhoct30.spring.test.mvc.domain.Realtor;
import com.skhoct30.spring.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {

	
	@Autowired
	private RealtorService realtorService;
	
	
	//한 행의 정보 얻어오기
	
	@GetMapping("/create")
	public String createRealtor(
			@RequestParam("office") String office
			,@RequestParam("phoneNumber") String phoneNumber
			,@RequestParam("address") String address
			,@RequestParam("grade") String grade
			, Model model) {
		
		// 여기서부터 아래로 순서대로 보면됨
		// realtor 에 정보를 담고 
		// 그 담은 정보를  model에 넣어서 활용한다.
		Realtor realtor = new Realtor();
		realtor.setOffice(office);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtor(realtor);
		
		model.addAttribute("realtor", realtor); // 키를 활용해서 값을 리턴가능
		// 모델에 html에 사용할 데이터를 저장해둔다.
		// 화면을 구성할 html을 만들어서 필요한 정보를 model 에 잠는다.
		
		
		return "mvc/realtor/info"; // html 파일 위치
		
		
		
		
		
	}
	
	@GetMapping("/input")
	public String realtorInput() {
		return "mvc/realtor/input";
	}
}
