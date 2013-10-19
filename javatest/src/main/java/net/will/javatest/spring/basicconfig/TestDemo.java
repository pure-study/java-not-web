/**
 * @(#)TestDemo.java - Will's practices of Project springtest.
 */
package net.will.javatest.spring.basicconfig;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Collection Objects Test.
 *
 * @author Will
 * @version v1.0, 2009-10-3
 *
 */
public class TestDemo {
	private static String springConfigFile = "classpath:config/spring-config-all.xml";
//	private static String springConfigFile
//			= "classpath:net/will/javatest/spring/basicconfig/beans-config.xml";
	
	private static Logger logger = Logger.getLogger(TestDemo.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfigFile);
		
		/* ===============Section 1=============== */
		logger.info("===============Section 1===============");
		BeansTest beansTest01 = (BeansTest) context.getBean("beansTest01");
		String[] strs = beansTest01.getSomeStrArray();
		for (int i = 0; i < strs.length; i++) {
//			System.out.println(strs[i]);
			logger.info(strs[i]);
		}
		List<Object> someList = beansTest01.getSomeList();
		for (int i = 0; i < someList.size(); i++) {
			Object obj = someList.get(i);
			logger.info(obj.toString());
		}
		Map<String, Object> someMap = beansTest01.getSomeMap();
		logger.info( someMap.get("key01").toString() );
		logger.info( someMap.get("key02").toString() );
		Properties someProperties = beansTest01.getSomeProperties();
		logger.info( someProperties.getProperty("prop01") );
		logger.info( someProperties.getProperty("prop02") );
		
		
		/* ===============Section 2=============== */
		logger.info("===============Section 2===============");
		BeansTest beansTest02 = (BeansTest) context.getBean("beansTest02");
		String[] strs2 = beansTest02.getSomeStrArray();
		for (int i = 0; i < strs2.length; i++) {
			logger.info(strs2[i]);
		}
		List<Object> someList2 = beansTest02.getSomeList();
		for (int i = 0; i < someList2.size(); i++) {
			Object obj = someList2.get(i);
			logger.info(obj.toString());
		}
		Map<String, Object> someMap2 = beansTest02.getSomeMap();
		logger.info( someMap2.get("Will").toString() );
		logger.info( someMap2.get("Michelle").toString() );
		Properties someProps2 = beansTest02.getSomeProperties();
		logger.info( someProps2.getProperty("prop11") );
		logger.info( someProps2.getProperty("prop12") );
		logger.info( someProps2.getProperty("prop13") );
		
		/* ===============Section 3=============== */
		logger.info("===============Section 3===============");
		BeansTest beansTest03 = (BeansTest) context.getBean("beansTest03");
		String[] strs3 = beansTest03.getSomeStrArray();
		for (int i = 0; i < strs3.length; i++) {
			logger.info(strs3[i]);
		}
		List<Object> someList3 = beansTest03.getSomeList();
		for (int i = 0; i < someList3.size(); i++) {
			Object obj = someList3.get(i);
			logger.info(obj.toString());
		}
		Map<String, Object> someMap3 = beansTest03.getSomeMap();
		logger.info( someMap3.get("mapUtilTagBean_Will").toString() );
		logger.info( someMap3.get("mapUtilTagBean_Michelle").toString() );
		Properties someProps3 = beansTest03.getSomeProperties();
		logger.info( someProps3.getProperty("Michelle") );
		logger.info( someProps3.getProperty("Will") );
	}

}
