package com.skhoct30.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhoct30.spring.test.mvc.service.SellerService;

@Controller
public class SellerController {
	
	
	@Autowired
	private SellerService sellerService;
	
	
	
	@RequestMapping("/mvc/seller/info")
	public String sellerInfo(Model model) {


	}
}
