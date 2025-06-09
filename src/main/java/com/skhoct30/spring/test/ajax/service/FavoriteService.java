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
		
		List<Favorite> favorite = favoriteRepository.selectFavorite();
		
		return favorite;
	}
	
}
