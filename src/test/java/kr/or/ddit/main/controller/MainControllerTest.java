package kr.or.ddit.main.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;


@WebAppConfiguration
public class MainControllerTest extends ControllerTestEnv{
	

	
	/**
	 * 
	* Method : mainViewTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : Main View 호출 테스트
	 * @throws Exception 
	 */
	@Test
	public void mainViewTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();	// 말 그대로 model과 view를 합쳐놓은것
		String viewName = mav.getViewName();
		String userId = (String)mav.getModel().get("mainUserId");
		/***Then***/
		assertEquals("tiles.main", viewName);
		assertEquals("brown", userId);
		assertNotNull(mav.getModel().get("rangers"));
		assertNotNull(mav.getModel().get("userVo"));
	}
	
	@Test
	public void mainViewAndExpectTest() throws Exception {
		
		// gwt문과 어울리진 않는다.
		mockMvc.perform(get("/main")).andExpect(status().isOk()) 
									.andExpect(view().name("tiles.main"))
									.andExpect(model().attribute("mainUserId", "brown"))
									.andExpect(model().attributeExists("rangers"))
									.andExpect(model().attributeExists("userVo"));
		
		
	}
	
	/**
	 * 
	* Method : mainViewMavTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : ModelAndView 객체를 이용한 main페이지 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void mainViewMavTest() throws Exception {
		/***Given***/
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/mainMav")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		// viewName이 기대하는 문자여롤 리턴 되는지
		assertEquals("main", mav.getViewName());
		
		
		// model객체에 Controller에서 설정한 속성이 있는지
		assertEquals("brown", mav.getModel().get("mainUserId"));
		assertNotNull(mav.getModel().get("rangers"));
	}

	/**
	 * 
	* Method : pathvariableTset
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : @Pathvariable 테스트
	 * @throws Exception 
	 */
	@Test
	public void pathvariableTset() throws Exception {
		
		mockMvc.perform(get("/main/pathvariable/brown"))
						.andExpect(status().isOk())
						.andExpect(view().name("main"));

	}
	
	/**
	 * 
	* Method : pathvariableTset
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : @Pathvariable 테스트
	 * @throws Exception 
	 */
	@Test
	public void pathvariableTset2() throws Exception {
		
		mockMvc.perform(get("/main/pathvariable/sally"))
						.andExpect(status().is(200))
						.andExpect(view().name("main"));

	}
	
	/**
	 * 
	* Method : requestHeaderTest
	* 작성자 : PC20
	* 변경이력 :
	* @throws Exception
	* Method 설명 : @RequestHeader 테스트
	 */
	@Test
	public void requestHeaderTest() throws Exception{
		mockMvc.perform(get("/main/header").accept("text/html"))
					.andExpect(status().is(200))
					.andExpect(view().name("main"));
			
	}
	
}
