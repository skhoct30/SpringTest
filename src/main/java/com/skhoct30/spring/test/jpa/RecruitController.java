package com.skhoct30.spring.test.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.jpa.domain.Recruit;
import com.skhoct30.spring.test.jpa.repository.RecruitRepository;

@Controller
@RequestMapping("/jpa/recruit")
public class RecruitController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/1")
	public Recruit findRecruit1() {
		
		Optional<Recruit> optionalRecruit = recruitRepository.findById(8);
		
		Recruit recruit = optionalRecruit.get();
		
		return recruit;
	}
	
	@ResponseBody
	@GetMapping("/2")
	public List<Recruit> findRecruit2(@RequestParam("comapnyId") int companyId) {
		
		List<Recruit> companyList = recruitRepository.findByCompanyId(companyId);
		
		return companyList;
	}
	
	@ResponseBody
	@GetMapping("/3")
	public List<Recruit> findRecruit3() {
		List<Recruit> recruitList = null;
		
		//3번문제
//		List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		
		
		//4번문제
//		recruitList = recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
		
		//5번 문제
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		//6번 문제
//		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		
		//7번 문제
		recruitList = recruitRepository.selectByQuery(LocalDate.of(2026, 4, 10), 8100, "정규직");
		
		
		
		return recruitList;
	}
	
	
}
