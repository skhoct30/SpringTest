package com.skhoct30.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhoct30.spring.test.ajax.domain.Favorite;
import com.skhoct30.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavorite() {
		
		List<Favorite> favoriteList = favoriteRepository.selectFavorite();
		
		return favoriteList;
	}
	
	
	// 즐겨찾기 추가 API
	
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	
	// 이메일 중복 확인 API
	
	public boolean isDuplicate(String url) {
		
		int count = favoriteRepository.selectCountByUrl(url);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
