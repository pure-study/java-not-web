/**
 * 
 */
package net.will.minispring;

/**
 * 
 * @author Will
 * @version 2013-8-10
 */
public class NoSuchBeanDefinitionException extends RuntimeException {
	private static final long serialVersionUID = -3320345172598328876L;

	public NoSuchBeanDefinitionException(String msg) {
		super(msg);
	}
	
	public NoSuchBeanDefinitionException(String msg, Throwable tx) {
		super(msg, tx);
	}
}
