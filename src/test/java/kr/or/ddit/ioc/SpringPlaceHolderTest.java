package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.placeholder.DbInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-placeholder.xml")
public class SpringPlaceHolderTest {

	@Resource(name = "dbInfo")
	private DbInfo dbInfo;
	
	
	@Test
	public void DbInfoTest() {
		
		/***Given***/
		

		/***When***/

		/***Then***/
		assertNotNull(dbInfo);
		assertEquals("oracle.jdbc.driver.OracleDriver", dbInfo.getDriver());
		assertTrue(dbInfo.getDriver().contains("OracleDriver"));
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", dbInfo.getUrl());
		assertTrue(dbInfo.getUrl().contains("1521"));
		assertEquals("PC20", dbInfo.getUsername());
		assertEquals("java", dbInfo.getPassword());
	}

}
