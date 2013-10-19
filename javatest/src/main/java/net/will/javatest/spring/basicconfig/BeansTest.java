/**
 * @(#)BeansTest.java - Will's practices of Project springtest.
 */
package net.will.javatest.spring.basicconfig;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-10-3
 *
 */
public class BeansTest {
	private String[] someStrArray;
	
	private List<Object> someList;
	
	private Map<String, Object> someMap;
	
	private Properties someProperties;

	/**
	 * @return the someStrArray
	 */
	public String[] getSomeStrArray() {
		return someStrArray;
	}

	/**
	 * @param someStrArray the someStrArray to set
	 */
	public void setSomeStrArray(String[] someStrArray) {
		this.someStrArray = someStrArray;
	}

	/**
	 * @return the someList
	 */
	public List<Object> getSomeList() {
		return someList;
	}

	/**
	 * @param someList the someList to set
	 */
	public void setSomeList(List<Object> someList) {
		this.someList = someList;
	}

	/**
	 * @return the someMap
	 */
	public Map<String, Object> getSomeMap() {
		return someMap;
	}

	/**
	 * @param someMap the someMap to set
	 */
	public void setSomeMap(Map<String, Object> someMap) {
		this.someMap = someMap;
	}

	/**
	 * @return the someProperties
	 */
	public Properties getSomeProperties() {
		return someProperties;
	}

	/**
	 * @param someProperties the someProperties to set
	 */
	public void setSomeProperties(Properties someProperties) {
		this.someProperties = someProperties;
	}
	
}
