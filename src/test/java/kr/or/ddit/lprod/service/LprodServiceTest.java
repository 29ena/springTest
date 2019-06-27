package kr.or.ddit.lprod.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.service.UserServiceTest;

public class LprodServiceTest extends LogicTestEnv{

private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Resource(name = "lprodService")
	private IlprodService lprodService;
	
	/**
	 * 
	* Method : lprodPagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : lprod 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest(){
		
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		
		int paginationSize = (Integer)resultMap.get("paginationSize");
		logger.debug("paginationSize : {}",paginationSize);
		/***Then***/
		// pagingList assert
		logger.debug("nullpoint : {}", lprodList);
		assertNotNull(lprodList);
		
		assertEquals(9, lprodList.size());
		
		// usersCnt assert
		assertEquals(2, paginationSize);
	}
	

}
