/**
 * 
 */
package net.will.minispring;

/**
 * 
 * @author Will
 * @version 2013-8-6
 */
public interface ApplicationContext {
	public <T> T getBean(String name);
}
