/**
 * 
 */
package net.will.common.webutil.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import net.will.common.webutil.StaticWebVariables;

import org.apache.log4j.Logger;

/**
 * This servlet must be loaded while the web server starts up. So you may
 * config it in web.xml like this:
 * <pre>
 * &lt;servlet&gt;
 *   &lt;servlet-name&gt;InitializationServlet&lt;/servlet-name&gt;
 *   &lt;servlet-class&gt;
 *       net.will.webtest.common.servlets.InitializationServlet
 *   &lt;/servlet-class&gt;
 *   &lt;load-on-startup&gt;0&lt;/load-on-startup&gt;
 * &lt;/servlet&gt;
 * </pre>
 * The smaller the load-on-startup value is, the higher the loading priority
 * will be.
 * 
 * @author Will
 * @version 2011-9-13
 */
public final class InitializationServlet extends HttpServlet {
	private static final long serialVersionUID = 3759303838227728338L;

	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			if (logger.isInfoEnabled()) {
				logger.info("Start to initialize...");
			}
			
			StaticWebVariables.rootDir = getServletContext().getRealPath("/");
			
			if (logger.isInfoEnabled()) {
				logger.info("Initialize done!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
