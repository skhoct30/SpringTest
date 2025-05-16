package com.skhoct30.spring.test.lifecycle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	
	
	@RequestMapping("/1")
	public String htmlResponse() {
		
		return ""
			+ "<html>\n"
			+ "		<head><title> Sprint </title></head>\n"
			+ "		<body>\n"
			+ "			<h2>테스트 프로젝트 완성</h2>\n"
			+ "			<div>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</div>\n"
			+ "		</body>\n"
			+ "</html>";
		
	}
	

	

}
