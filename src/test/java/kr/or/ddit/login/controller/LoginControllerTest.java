package kr.or.ddit.login.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;
import kr.or.ddit.user.model.UserVo;

public class LoginControllerTest extends ControllerTestEnv{

	/**
	 * 
	* Method : loginViewNotLoginTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 접속하지 않은 상황에서 loginView 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginViewNotLoginendTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("login/login", viewName);

	}
	
	/**
	 * 
	* Method : loginViewLoginTest
	* 작성자 : PC20
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 로그인한 상황에서 로그인 뷰 오청 테스트
	 */
	@Test
	public void loginViewLoginendTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login").sessionAttr("USER_INFO", new UserVo())).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		/***Then***/
		assertEquals("tiles.main", viewName);
		
	}
	
	/**
	 * 
	* Method : loginProcessSuccessTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 로그인 요청 처리 성공 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginProcessSuccessTest() throws Exception {
		/***Given***/
		String userId = "brown";
		String password = "1234";
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/login")
									.param("userId", userId)
									.param("password", password))
									.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		HttpSession session = mvcResult.getRequest().getSession();
		
		String viewName = mav.getViewName();
		UserVo userVo = (UserVo)session.getAttribute("USER_INFO");
		
		/***Then***/
		assertEquals("tiles.main", viewName);
		assertEquals("브라운", userVo.getName());
		assertEquals("곰", userVo.getAlias());
	}
	
	/**
	 * 
	* Method : loginProcessFailTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 로그인 요청 처리 실패 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginProcessFailTest() throws Exception {
		/***Given***/
		String userId = "brown";
		String password = "1235";	// 틀린 비밀번호
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/login")
									.param("userId", userId)
									.param("password", password))
									.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		/***Then***/
		assertEquals("login/login", viewName);
	}

}
