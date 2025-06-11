package com.skhoct30.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.test.ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	// 리스트 가져오기
	public List<Booking> selectBooking();
	
}
