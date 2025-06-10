package com.skhoct30.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.skhoct30.spring.test.ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {
	
	public List<Favorite> selectFavorite();
	
	
	// 즐겨찾기 추가 기능API
	// insert는 행의 개수 int
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
}
