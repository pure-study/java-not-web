/**
 * 
 */
package net.will.selftools.fileencodetranster;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author Will
 * @version 2010-12-16
 *
 */
public class FileEncodeTransferMain {
	private static Logger logger = Logger.getLogger(FileEncodeTransferMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String srcPath = "";
		String destPath = "";
		String srcEncoding = "";
		String destEncoding = "";
		
		StringBuilder sb = new StringBuilder();
		for (String arg : args) {
			sb.append(arg);
			sb.append(" ");
		}
		logger.info("process options: " + sb.toString());

		FileEncodeTransferTool tool = new FileEncodeTransferTool();
//		tool.setSrcEncoding("GBK");
//		tool.setDestEncoding("UTF-8");
		
		try {
			if ( args.length != 4 ) {
				showUsage();
				return;
			}
			for (String arg : args) {
				String argv = null;
				
				argv = processArgument("srcPath", arg);
				if (null != argv) {
					srcPath = argv;
					logger.info("srcPath: " + srcPath);
					continue;
				}
				
				argv = processArgument("destPath", arg);
				if (null != argv) {
					destPath = argv;
					logger.info("destPath: " + destPath);
					continue;
				}
				
				argv = processArgument("srcEncoding", arg);
				if (null != argv) {
					srcEncoding = argv;
					logger.info("srcEncoding: " + srcEncoding);
					continue;
				}
				
				argv = processArgument("destEncoding", arg);
				if (null != argv) {
					destEncoding = argv;
					logger.info("destEncoding: " + destEncoding);
					continue;
				}
				
				if (null == argv) {
					logger.warn("invalid option: " + arg);
				}
			}

			tool.setSrcEncoding(srcEncoding);
			tool.setDestEncoding(destEncoding);
			tool.transferWithSameNames(new File(srcPath), new File(destPath));
//			tool.transfer("G:/ExcelParseUtil.java", "G:/1/ExcelParseUtil.java");
//			System.out.println(System.getProperty("user.dir"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Parses a argument string with a format like this:</p>
	 * 
	 * <blockquote><pre>
	 * argName=argValue
	 * </pre></blockquote>
	 * 
	 * <p>if the format is correct, returns the argument value; otherwise, returns
	 * <code>null</code>.</p>
	 * 
	 * @param expectedArgName argument name
	 * @param arg argument string to process
	 * @return
	 */
	private static String processArgument(String expectedArgName, String arg) {
		String argValue = null;
		// a tailing non-space character sequence behind '=' will be the argement value: 
		Pattern ptn = Pattern.compile(expectedArgName + "=(\\S+)");
		
		Matcher mch = ptn.matcher(arg);
		if ( mch.find() ) {
//			logger.debug(mch.group());
			logger.debug(mch.group(0));
			logger.debug(mch.group(1));
			
			argValue = mch.group(1);
		}
		
		return argValue;
	}

	private static void showUsage() {
		// TODO: modify the usage information
		System.out.println(FileEncodeTransferMain.class.getSimpleName()
			+ " -srcPath=SourcePath"
			+ " -destPath=DestinationPath"
			+ " -srcEncoding=SourceEncoding"
			+ " -destEncoding=DestinationEncoding");
	}

}
