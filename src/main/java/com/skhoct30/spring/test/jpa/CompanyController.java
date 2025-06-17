package com.skhoct30.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.jpa.domain.Company;
import com.skhoct30.spring.test.jpa.service.CompanyService;

@Controller
@RequestMapping("/jpa/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	
	// 추가하는 기능
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany() {
		
		List<Company> companyList = new ArrayList<>();
		
		
		Company company = companyService.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		companyList.add(company);
		
		company = companyService.addCompany("버블팡", "여신 금융업", "대기업", 6934);
		companyList.add(company);
		
		return companyList;
		
	}
	
	
	// 수정하는 기능 Update
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		// 회사명 버블팡 (id값으로 접근하기로 했음)
		Company company = companyService.updateCompany(8, "중소기업", 34);
		
		return company;
		
	}
	
	
	// 삭제하는 기능 delete
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		
		// 회사명 버블팡 id값 8
		//                          삭제하고 싶어하는 id값
		companyService.deleteCompany(10);
		return "삭제성공";
		
	}
	
	
	
	

	
	
	
	
	
	
	
}
