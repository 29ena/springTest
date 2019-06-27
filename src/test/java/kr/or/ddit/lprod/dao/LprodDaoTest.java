package kr.or.ddit.lprod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class LprodDaoTest extends LogicTestEnv{
	
	private static final Logger logger = LoggerFactory.getLogger(LprodDaoTest.class);
	
	@Resource(name = "lprodDao")
	private IlprodDao lprodDao;
	
	/**
	 * 
	* Method : lprodsCntTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : lprod 전체수 조회
	 */
	@Test
	public void lprodsCntTest(){
		/***Given***/
		

		/***When***/
		int lprodsCnt = lprodDao.lprodsCnt();
		/***Then***/
		assertNotNull(lprodsCnt);
		assertEquals(9, lprodsCnt);
		logger.debug("lprodsCnt : {}", lprodsCnt);
	}
	
	/**
	 * 
	* Method : lprodListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : lprod 전체 리스트 조회 테스트
	 */
	@Test
	public void lprodListTest() {
		/***Given***/
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodList();
		/***Then***/
		assertNotNull(lprodList);
		assertTrue(lprodList.size() >= 9 );
		assertEquals(9, lprodList.size());
	}
	
	/**
	 * 
	* Method : lprodPagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : lprod 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);
		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodPagingList(pageVo);
		/***Then***/
		assertEquals(9, lprodList.size());
		
	}
	
	

}
