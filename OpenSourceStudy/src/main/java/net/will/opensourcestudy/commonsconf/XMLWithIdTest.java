/**
 * @(#)XMLWithIdTest.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.commonsconf;

import java.io.File;
import java.util.List;

import org.apache.commons.configuration.XMLConfiguration;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2010-2-25
 *
 */
public class XMLWithIdTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			XMLConfiguration config = new XMLConfiguration();
			config.setFile(new File("src/main/java/net/will/opensourcestudy/commonsconf/xmlwithid.xml"));
			config.load();
			
			String key01 = "clear.element[@id]";
			String key02 = "clear.list.item[@id]";
			System.out.println(config.getProperty(key01));
			System.out.println(config.getProperty(key02));
			System.out.println(config.getString("clear.list.item(0)[@id]"));
			System.out.println(config.getString("clear.list.item(0)"));
			System.out.println(config.getStringArray("clear.list.item").length);
			
			List props = (List) config.getProperty(key02);
			System.out.println(props.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
