package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.dao.IboardDao;
import kr.or.ddit.board.service.IboardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-st.xml")
public class SpringIocTest {
	
	@Resource(name="boardDao")
	private IboardDao boardDao;
	
	@Resource(name="boardService")
	private IboardService boardService;
	
	/**
	 * 
	* Method : test
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 스프링 컨테이너 생성 테스트
	 */
	@Test
	public void springIocTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals(boardDao, boardService.getBoardDao());
	}

}
