package com.skhoct30.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.skhoct30.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	// 한 행의 정보를 리스트에 넣어야지
	// Natity 클래스 (domain) 에 작성해서 받아와한다.
	public List<Weather> selectWeather();

}
