package com.skhoct30.spring.test.ajax.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.ajax.domain.Booking;
import com.skhoct30.spring.test.ajax.repository.BookingRepository;

@Service
public class BookingService {
	
	
	@Autowired
	private BookingRepository bookingRepository;
	
	// list 불러오기
	
	public List<Booking> getBooking() {
		
		List<Booking> bookingList = bookingRepository.selectBooking();
		
		return bookingList;
		
	}
	
	// 삭제버튼을 위한 api
	
	public int deleteBooking(int id) {
		
		int count = bookingRepository.deleteBooking(id);
		
		return count;
		
	}
	
	
	// 추가하는 input 기능 API
	
	public int addBooking(
			String name
			, LocalDate date
			, int day
			, int headcount
			, String phoneNumber
			) {
		
		int count = bookingRepository.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
		
		return count;
	}
	
	
	// 이름과 전화번호를 이용해 사용자 정보 조회
	

	
	
	
}
