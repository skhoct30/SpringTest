package com.skhoct30.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.thymeleaf.domain.Weather;
import com.skhoct30.spring.test.thymeleaf.repository.WeatherRepository;

@Service
public class WeatherService {
	

	@Autowired
	private WeatherRepository weatherRepository;
	
	// 목표는 하나의 정보가 아니다
	// 모든 행의 정보
	// 모든 날씨 정보 리 스트 얻어오기
	public List<Weather> getWeather() {
		// weatherhistory 테이블 sql 의 모든 행의 정보 조회
		List<Weather> weather = weatherRepository.selectWeather();
		
		return weather;
	}
	
	
	// 저장 기능
	public int addWeather(
			LocalDate date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return count;
	}
	
}
