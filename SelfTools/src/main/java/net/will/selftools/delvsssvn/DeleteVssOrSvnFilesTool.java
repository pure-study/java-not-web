/**
 * 
 */
package net.will.selftools.delvsssvn;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.log4j.Logger;

/**
 * Lazy Singleton Tool for deleting VSS or SVN files.
 * 
 * @author Will
 * @version 2011-1-10
 *
 */
public class DeleteVssOrSvnFilesTool {
//	private Logger logger = Logger.getLogger(getClass());
	private Log log = LogFactory.getLog(getClass());
	
	/**
	 * 根据全文件名匹配
	 */
	private String[] delFnFull = new String[] {"vssver.scc"};

	/**
	 * 根据文件名后缀匹配
	 */
	private String[] delFnSuffix = new String[] {".svn"};
	
	/**
	 * 根据文件名前缀匹配
	 */
	private String[] delFnPrefix = new String[] {};
	
	private static String fs = System.getProperty("file.separator");
	
	/**
	 * 执行删除操作。该工具类的主要对外接口之一。
	 * 
	 * @param operDir
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int executeDeletingOper(String operDir) {
		File operDirFile = new File(operDir);
		if (null==operDirFile || !operDirFile.isDirectory()) {
			throw new IllegalArgumentException("文件为空，或者不为文件夹！");
		}
		
		return executeDeletingOper(operDirFile);
	}
	
	/**
	 * 执行删除操作。该工具类的主要对外接口之一。
	 * 
	 * @param operDirFile
	 * @return
	 * @throws IllegalArgumentException
	 */
	public int executeDeletingOper(final File operDirFile) {
		int delCount = 0;
		if (null==operDirFile || !operDirFile.isDirectory()) {
			throw new IllegalArgumentException("文件为空，或者不为文件夹！");
		}
		
		String[] files = operDirFile.list();
		String absPath = operDirFile.getAbsolutePath();
//		logger.debug(operDirFile.getAbsolutePath());
		log.debug(operDirFile.getAbsolutePath());
		for (int i = 0; i < files.length; i++) {
			String filename = files[i];
			
			File filea = new File(absPath + fs + filename);
			if (filea!=null && filea.isDirectory()) {
				if ( matchToDelete(filename) ) {  // 如果是文件夹，且需要删除
					deleteWholeDir(filea);
					continue;
				}
				
				// 如果是文件夹，但不需要被删除，则进行迭代，轮循文件夹里的文件
				executeDeletingOper(filea);
			} else {
				if ( matchToDelete(filename) ) {
					deleteFileWithLog(filea);
				}
			}
		}
		
		return delCount;
	}
	
	/**
	 * 根据delFnFull，delFnSuffix，delFnPrefix来匹配文件名（是否需要删除），如果按规则能够匹配
	 * 成功的话，那么就返回true，否则返回false。
	 * 
	 * @param filename
	 * @return
	 * @throws NullPointerException
	 */
	public boolean matchToDelete(String filename) {
		if (null == filename) {
			throw new NullPointerException("不能对空文件名进行相关操作！");
		}
		
		for (int i = 0; i < delFnFull.length; i++) {
			String fnFullPtn = delFnFull[i];
			if (fnFullPtn.equals(filename)) {
				return true;
			}
		}
		
		for (int i = 0; i < delFnSuffix.length; i++) {
			String fnSuffix = delFnSuffix[i];
			if (filename.endsWith(fnSuffix)) {
				return true;
			}
		}
		
		for (int i = 0; i < delFnPrefix.length; i++) {
			String fnPrefix = delFnPrefix[i];
			if (filename.startsWith(fnPrefix)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 删除整个文件夹。如果删除文件夹中某个文件或文件夹时失败，那么整个删除操作将终止。
	 * 
	 * @param dir 必须是一个文件夹，否则直接返回false
	 * @return
	 */
	private boolean deleteWholeDir(File dir) {
		boolean delok = false;
		if (!dir.isDirectory()) {
			delok = false;
			return delok;
		}
		
		// 1. 先删文件夹下面的所有文件、文件夹
		String[] filesInDir = dir.list();
		String absPath = dir.getAbsolutePath();
		for (int i = 0; i < filesInDir.length; i++) {
			String filename = filesInDir[i];
			
			File filea = new File(absPath + fs + filename);
			if (filea!=null && filea.isDirectory()) {
				delok = deleteWholeDir(filea);  // 遇到文件夹，则进行迭代
				
				if (!delok) {   // 如果遇到删除失败，则整个删除动作终止
					return delok;
				}
			} else {
				delok = deleteFileWithLog(filea);
				
				if (!delok) {   // 如果遇到删除失败，则整个删除动作终止
					return delok;
				}
			}
		}
		
		// 2. 再删此文件夹本身(此时，该文件夹已经为空)
		delok = deleteFileWithLog(dir);
		return delok;
	}
	
	/**
	 * 删除一个文件，并打印相应的日志。本方法不检查，此文件是否为文件夹，所以如果传进来的
	 * 参数是一个文件夹，并且不为空的话，将会删除失败。
	 * 
	 * @param filea
	 * @return 删除成功，则返回true；否则返回false。
	 */
	private boolean deleteFileWithLog(File filea) {
		boolean delok = false;
		
//		logger.info("Start to delete file: [" + filea.getAbsolutePath() + "]...");
		log.info("Start to delete file: [" + filea.getAbsolutePath() + "]...");
		delok = filea.delete();
		if (delok) {
//			logger.info("Delete file: [" + filea.getAbsolutePath() + "] success!");
			log.info("Delete file: [" + filea.getAbsolutePath() + "] success!");
		} else {
//			logger.info("Delete file: [" + filea.getAbsolutePath() + "] failed!");
			log.info("Delete file: [" + filea.getAbsolutePath() + "] failed!");
		}
		return delok;
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ getter & setter ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public String[] getDelFnFull() {
		return delFnFull;
	}

	public void setDelFnFull(String[] delFnFull) {
		if (null == delFnFull) {
			delFnFull = new String[] {};
		}
		this.delFnFull = delFnFull;
	}

	public String[] getDelFnSuffix() {
		return delFnSuffix;
	}

	public void setDelFnSuffix(String[] delFnSuffix) {
		if (null == delFnSuffix) {
			delFnSuffix = new String[] {};
		}
		this.delFnSuffix = delFnSuffix;
	}

	public String[] getDelFnPrefix() {
		return delFnPrefix;
	}

	public void setDelFnPrefix(String[] delFnPrefix) {
		if (null == delFnPrefix) {
			delFnPrefix = new String[] {};
		}
		this.delFnPrefix = delFnPrefix;
	}
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Lazy Singleton ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static DeleteVssOrSvnFilesTool sgl_instance = null;
	
	private DeleteVssOrSvnFilesTool() {
		// NOP
	}
	
	public synchronized static DeleteVssOrSvnFilesTool getInstance() {
		if (null == sgl_instance) {
			sgl_instance = new DeleteVssOrSvnFilesTool();
		}
		
		return sgl_instance;
	}
}
