package com.skhoct30.spring.test.ajax;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.ajax.domain.Booking;
import com.skhoct30.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.getBooking();
		
		model.addAttribute("bookingList", bookingList);
		
		return "ajax/booking/list";
	}
	
	
	
	// 삭제를 위한 API
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id")int id) {
		
		Map<String, String> resultMap = new HashMap<>();
		
		int count = bookingService.deleteBooking(id);
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	// input 페이지
	
	@GetMapping("/input")
	public String addBooking() {
		
		return "ajax/booking/input";
	}
	
	
	
	// 추가하는기능(저장하는기능) API 
	@ResponseBody
	@GetMapping("/create")
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date // 날짜 시간의 규격을 정하는게 좋다. - 2025년 6월 12일 
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		
		// 저장에 대한 성공 실패 여뷰
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		// {"result":"success"} 성공
		// {"result":"fail"} 실패
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 1이면 sql 에서 성공된 자료가 넘어오면 1로 전달받음
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		
		return resultMap;
		
	}
	
	
	// Select 테이블 조회
	@GetMapping("/select")
	public String selectBooking() {
		
		return "ajax/booking/select";
	}
	
	
	// 이름 전화번호를 통한 예약확인
//	@GetMapping("/select-list")
//	public  selectBybooking(
//			@RequestParam("name") String name
//			, @RequestParam("phoneNumber") String phoneNumber) {
//		
//		bookingService.selectBybooking(name, phoneNumber);
//		
//	}
	
	
	
}
