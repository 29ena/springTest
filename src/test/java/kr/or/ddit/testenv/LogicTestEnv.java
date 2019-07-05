package kr.or.ddit.testenv;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jdk.nashorn.internal.ir.annotations.Ignore;
import kr.or.ddit.config.spring.ApplicationDatasource;
import kr.or.ddit.config.spring.ApplicationTransaction;
import kr.or.ddit.config.spring.RootContext;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:kr/or/ddit/config/spring/root-context.xml"
//						, "classpath:kr/or/ddit/config/spring/application-datasource-dev.xml"
//						, "classpath:kr/or/ddit/config/spring/application-transaction.xml"})
@ContextConfiguration(classes = {RootContext.class
								, ApplicationDatasource.class
								, ApplicationTransaction.class})
public class LogicTestEnv {
	
	@Resource(name = "datasource")
	private DataSource datasource;
	
	@Before
	public void serup() {
		ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
		rdp.setContinueOnError(false);  // 에러 발생시 계속 할지 정하는 메서드
		rdp.addScript(new ClassPathResource("kr/or/ddit/testenv/dbInit.sql"));
		
		DatabasePopulatorUtils.execute(rdp, datasource);
	}
	@Ignore
	@Test
	public void dummy() {
		
	}
}
