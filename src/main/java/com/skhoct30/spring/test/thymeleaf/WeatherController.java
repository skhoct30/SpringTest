package com.skhoct30.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhoct30.spring.test.thymeleaf.domain.Weather;
import com.skhoct30.spring.test.thymeleaf.service.WeatherService;

@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {
	
	
	@Autowired
	private WeatherService weatherService;
	
	// 이거는 일단 정보가 잘 왔는 지 내가 확인할라고 만든 기능
	@ResponseBody
	@GetMapping("/main")
	public List<Weather> weatherMain() {
		
		List<Weather> weatherList = weatherService.getWeather();
		
		return weatherList;
	}
	
	
	
	
	
	
	
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		// 데이터 베이스에 있는 정보를 얻어와야한다.
		// 이제 service 로 가서 다시 확인부터 시작해야한다.
		
		List<Weather> weatherHistory = weatherService.getWeather();
		// weatherList 실제 리스트 객체가 저장되어 있는데 
		
		// 이걸 모델에 이제 넣어줘야한다.
		model.addAttribute("weatherHistory", weatherHistory);
		
		
		return "thymeleaf/weather/list";
	}
	
	
	
	//저장하는 기능
	@GetMapping("/create")
	public String createWeather(
//			@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date // 2025년 5월 30일 << 이걸 컴퓨터한테 알려줘야한다 어떤게 년 월 일 인지
//			, @RequestParam("weather") String weather
//			, @RequestParam("temperatures") double temperatures
//			, @RequestParam("precipitation") double precipitation
//			, @RequestParam("microDust") String microDust
//			, @RequestParam("windSpeed") double windSpeed
			@ModelAttribute Weather weather) {
		
		
//		int count = weatherService.addWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		weatherService.addWeatherByObject(weather);
		
		return "redirect:/thymeleaf/weather/list";
		
		
	}
	
	
	
	
	
	// input html 페이지 가는 기능
	@GetMapping("/input")
	public String weatherInput() {
		
		return "thymeleaf/weather/input";
	}
	
}
