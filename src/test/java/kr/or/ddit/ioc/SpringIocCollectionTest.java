package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.ioc.collection.IocCollection;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-collection.xml")
public class SpringIocCollectionTest {
	
	@Resource(name = "collectionBean")
	private IocCollection iocCollection;
	
	
	@Test
	public void iocCollectionTest() {
		/***Given***/
		

		/***When***/
		
		/***Then***/
		assertNotNull(iocCollection.getMap());
		assertEquals("brown", iocCollection.getList().get(0));
		assertEquals("brown", iocCollection.getMap().get("name"));
		assertEquals("2019-08-08", iocCollection.getMap().get("birth"));
		assertTrue(iocCollection.getSet().contains("brown"));
		assertEquals("brown", iocCollection.getProperties().get("userId"));
	}

}
