package kr.or.ddit.prod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.testenv.LogicTestEnv;

public class ProdDaoTest extends LogicTestEnv {

	@Resource(name = "prodDao" )
	private IprodDao prodDao;
	
	/**
	 * 
	* Method : prodListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : prod 전체 리스트 조회
	 */
	@Test
	public void prodListTest() {
		/***Given***/
		
		/***When***/
		List<ProdVo> prodList = prodList = prodDao.prodList();
		/***Then***/
		assertNotNull(prodList);
		assertTrue(prodList.size() >= 74 );
		assertEquals(74, prodList.size());
	}
	
	/**
	 * 
	* Method : prodsCntTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : prod 전체 수 조회
	 */
	@Test
	public void prodsCntTest() {
		/***Given***/
		
		/***When***/
		int prodsCnt = prodDao.prodsCnt();
		/***Then***/
		assertNotNull(prodsCnt);
		assertEquals(74, prodsCnt);
	}
	
	/**
	 * 
	* Method : prodPagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : prod 페이징 리스트 조회 테스트
	 */
	@Test
	public void prodPagingListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);
		/***When***/
		List<ProdVo> prodList = prodDao.prodPagingList(pageVo);
		/***Then***/
		assertEquals(10, prodList.size());
	}
	

}
