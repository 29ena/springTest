package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.testenv.LogicTestEnv;
import kr.or.ddit.user.model.UserVo;


public class UserServiceTest extends LogicTestEnv {

	@Resource(name = "userService")
	private IuserService userService;
	
	@Test
	public void userListTest() {
		/***Given***/
			

		/***When***/
		List<UserVo> userList = userService.userList();
		/***Then***/
		assertNotNull(userList);
		assertTrue(userList.size() >= 100 );
		assertEquals(108, userList.size());
		
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트, 삭제 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException{
		
		/***Given***/
		// 사용자정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕인", "userTest", "중앙로", "1234", "대전광역시 중구 중앙로76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31") );
		

		/***When***/
		// userDao.insertUser() 실행
		int insertCnt = userService.insertUser(userVo);
		/***Then***/
		// insertCnt(1)인지 확인
		assertEquals(1, insertCnt);
		
		// data삭제
		userService.deleteUser(userVo.getUserId());
	}
	
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVo userVo = userService.getuser(userId);
		/***Then***/
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
	};
	
	

}
