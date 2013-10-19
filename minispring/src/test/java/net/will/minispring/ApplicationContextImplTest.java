/**
 * 
 */
package net.will.minispring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.will.minispring.testobj.TestBo;
import net.will.minispring.testobj.TestDao;

import org.junit.Test;

/**
 * 
 * @author Will
 * @version 2013-8-6
 */
public class ApplicationContextImplTest {

	@Test
	public void testGetBeanSimple() {
		ApplicationContext context = new ApplicationContextImpl("src/test/resources/net/will/minispring/beans-config.xml");
		TestDao testdao = context.getBean("testDao");
		assertNotNull(testdao);
		
		assertEquals(testdao.getTable(), "user");
		assertTrue(10 == testdao.getMaxCnt());
	}
	
	@Test
	public void testGetBeanSingleton() {
		ApplicationContext context = new ApplicationContextImpl("src/test/resources/net/will/minispring/beans-config.xml");
		TestDao testdao = context.getBean("testDao");
		assertNotNull(testdao);
		
		TestDao td2 = context.getBean("testDao");
		assertNotNull(td2);
		
		assertTrue(testdao == td2);
	}
	
	@Test
	public void testGetBeanPrototype() {
		ApplicationContext context = new ApplicationContextImpl("src/test/resources/net/will/minispring/beans-config-prototype.xml");
		TestDao testdao = context.getBean("testDao");
		assertNotNull(testdao);
		
		for (int i = 0; i < 5; i++) {
			TestDao td = context.getBean("testDao");
			assertNotNull(td);
			assertFalse(testdao == td);
		}
	}
	
	@Test
	public void testGetBeanWithReference() {
		ApplicationContext context = new ApplicationContextImpl("src/test/resources/net/will/minispring/beans-config.xml");
		TestBo testbo = context.getBean("testBo");
		assertNotNull(testbo);
		
		TestDao testdao = testbo.getDao();
		assertNotNull(testdao);
		assertEquals(testdao.getTable(), "user");
		assertTrue(10 == testdao.getMaxCnt());
	}

}
