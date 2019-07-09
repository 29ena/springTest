package kr.or.ddit.batch.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;

public class BatchDaoTest extends LogicTestEnv{

	@Resource(name = "batchService")
	private IBatchService batchService;
	
	/**
	 * 
	* Method : deleteDialyTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 일실적 일괄 생성 테스트
	 */
	@Test
	public void createDialyTest() {
		/***Given***/
		String ym = "201907";
		
		/***When***/
		int createCnt = batchService.createDaily(ym);
		/***Then***/
		assertEquals(69, createCnt);
	}

}
