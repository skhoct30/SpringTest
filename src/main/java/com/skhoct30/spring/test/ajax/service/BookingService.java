package com.skhoct30.spring.test.ajax.service;

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
	
	
}
