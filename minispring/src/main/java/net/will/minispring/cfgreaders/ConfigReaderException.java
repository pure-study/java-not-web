/**
 * 
 */
package net.will.minispring.cfgreaders;

/**
 * 
 * @author Will
 * @version 2013-8-10
 */
public class ConfigReaderException extends RuntimeException {
	private static final long serialVersionUID = 4551027766965424865L;

	public ConfigReaderException(String msg) {
		super(msg);
	}
	
	public ConfigReaderException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
