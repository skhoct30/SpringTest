package com.skhoct30.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	// 한 행의 정보를 리스트에 넣어야지
	// Natity 클래스 (domain) 에 작성해서 받아와한다.
	public List<Weather> selectWeather();
	
	
	public int insertWeather(
			@Param("date") LocalDate date // Localdate 쓰면 2025-05-30 
			, @Param("weather") String weather
			, @Param("temperatures") double temperatures
			, @Param("precipitation") double precipitation
			, @Param("microDust") String microDust
			, @Param("windSpeed") double windSpeed);
	
	
	// 추가기능
	
	public int insertWeatherByObject(Weather weather);

}
