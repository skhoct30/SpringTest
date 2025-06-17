package com.skhoct30.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skhoct30.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	
	
	
	// 2번 문제
	// Request Parameter 로 전달받은 company id 로 해당하는 회사의 공고 출력
	// "SELECT * FROM `recruit` WHERE `companyId` = :companyId", nativeQuery=true
	
	// 첫번째 풀이
//	@Query(value="SELECT * FROM `recruit` WHERE `companyId` = :companyId", nativeQuery=true)
//	public List<Recruit> selectByQuery(@Param("companyId") int companyId);
	
	// 주로사용하는 두번째 풀이
	
	public List<Recruit> findByCompanyId(int companyId);
	
	
	
	// 3번 문제
	// 웹 back-end 개발자 이고 정규직 인 공고를 조회하고 출력
	// WHERE `position` = #{} AND `type` = #{}
	
	public List<Recruit> findByPositionAndType(String position, String type);
	
	
	
	// 4번 문제
	// 정규직 이거나 연봉이 9000 이상인 공고를 조회하고 출력
	// WHERE `type` = #{} OR `salary` >= #{}
	// GreaterThanEqual 를 뒤에 넣으면 '~이상' 이라고 조건을 나타냄
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	
	
	// 5번 문제
	// 계약직 목록 / 연봉기준 / 내림차순 / 3개만
	// WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3;
	// 주의사항 !! : By 는 where 의 조건을 나타내는것 조건을 걸고 시작할 때 사용하는거라서 또 사용하면 안됨
	// 갯수제한은 앞으로 와야함 Top1~3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	
	
	// 6번 문제
	// 지역 : 성남시 분당구 / 연봉 : 7000이상 8500 이하  공고 조회
	// WHERE `region` = #{} AND `salary` BETWEEN #{} AND #{}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	
	
	// 7번 문제
	// 마감일 : 2026-04-10 이후 / 연봉 : 8100이상 인 정규직 공고 / 연봉 기준으로 내림차순
	// 쿼리구성에 문제 없게 줄바꿈을 했을 때 엔터를 한번씩 눌러주면 좋다. 습관화
	@Query(value="SELECT * FROM `recruit`"
			+ " WHERE `deadline` > :deadline"
			+ " AND `salary` >= :salary"
			+ " AND `type` = :type"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByQuery(
			@Param("deadline") LocalDate deadline
			, @Param("salary") int salary
			, @Param("type") String type);
	
	
}
