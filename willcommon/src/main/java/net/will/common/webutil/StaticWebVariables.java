/**
 * 
 */
package net.will.common.webutil;

/**
 * @author Will
 * @version 2011-9-13
 */
public final class StaticWebVariables {
	/**
	 * The real root path of the application. It should be initialized when the server starts up.
	 * Here is an example value: %CATALINA_HOME%/webapps/webtest/.
	 */
	public static String rootDir = "";
	
	private StaticWebVariables() {}
}
