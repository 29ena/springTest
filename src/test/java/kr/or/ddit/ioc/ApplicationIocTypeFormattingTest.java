package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.typeConvert.model.FormattingVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-formatting.xml")
public class ApplicationIocTypeFormattingTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationIocTypeFormattingTest.class);
	
	@Resource(name = "formattingVo")
	private FormattingVo fmtVo;
	
	/**
	 * 
	* Method : formattingTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : Date formatting Test
	 */
	@Test
	public void formattingTest() {
		/***Given***/
		

		/***When***/
		SimpleDateFormat sdt1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdt2 = new SimpleDateFormat("MM-dd-yyyy");
		
		String reg_dt = sdt1.format(fmtVo.getReg_dt());
		String mod_dt = sdt2.format(fmtVo.getMod_dt());
		
		logger.debug("reg_dt : {}", reg_dt);
		logger.debug("mod_dt : {}", mod_dt);
		logger.debug("number : {}", fmtVo.getNumber());
		/***Then***/
		assertEquals("2019-06-21", reg_dt);
		assertEquals("06-21-2019", mod_dt);
		assertEquals(6000, fmtVo.getNumber());	// "6,000" -> 6000
		
	}

}
