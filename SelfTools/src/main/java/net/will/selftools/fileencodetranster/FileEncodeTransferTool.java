/**
 * 
 */
package net.will.selftools.fileencodetranster;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Will
 * @version 2010-12-16
 *
 */
public class FileEncodeTransferTool {
	private static Logger logger = Logger.getLogger(FileEncodeTransferTool.class);
	
	private String srcEncoding = "GBK";
	private String destEncoding = "UTF-8";
	
	/**
	 * 哪些文件类型将被转码。不区分大小写。
	 */
	private String[] extAccepts = new String[] { "java", "xml", "jps", "htc",
			"jsp", "properties", "css", "js", "html", "htm", "txt"};

	private static String fs = System.getProperty("file.separator");
	
	private static String EXP_INFO = "不能直接对一个空文件或者文件夹进行转码！";
	
	/**
	 * 按源目录结构，生成一个新的目录结构，里面的文件相对路径不变，所有文件使用新的编码。
	 * 
	 * @param srcDir 源目录
	 * @param destDir 目标目录
	 */
	public void transferWithSameNames(final File srcDir, final File destDir) {
		if (null==srcDir || !srcDir.isDirectory()) {
			logger.error("source file doesn't exist or is not a directory!");
			return;
		}
		if (null==destDir) {
			logger.error("NullPointException: destDir is null!");
			return;
		}
		destDir.mkdirs();
		
		// 文件过滤
		String[] files = srcDir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir.getAbsolutePath() + fs + name);
				if (file.isDirectory()) {  // directory is permitted
					return true;
				}
				
				if (null == name || name.lastIndexOf('.') < 0
						|| name.lastIndexOf('.') >= name.length()-1) {
					return false;
				}
				
				String ext = name.substring(name.lastIndexOf('.') + 1);
				for (int i = 0; i < extAccepts.length; i++) {
					String exta = extAccepts[i];
					if (exta.equalsIgnoreCase(ext)) {
						return true;
					}
				}
				return false;
			}
			
		});

		// 生成新目录树，同时对新文件进行转码
		String absPath = srcDir.getAbsolutePath();
		logger.debug(absPath);
		for (int i = 0; i < files.length; i++) {
			String filename = files[i];
			File filea = new File(absPath + fs + filename);
			
			// 如果是文件夹，则生成对应目标目录之后，进行迭代，否则直接进行转码操作
			if (filea!=null && filea.isDirectory()) {
				File fileaDest = new File(destDir.getAbsolutePath() + fs + filename);
				fileaDest.mkdirs();
				transferWithSameNames(filea, fileaDest);
			} else {
				File newFile = new File(destDir.getAbsolutePath() + fs + filename);
				
				try {
					newFile.createNewFile();
					transfer(filea, newFile);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}  // END if...else...
		}      // END for
	}
	
	/**
	 * 将某文件夹下的 所有文件列举出来，不包括文件夹，但包括所有子目录里的文件。
	 * 
	 * @param dir
	 * @return
	 */
	public List<File> listFilesInDir(File dir) {
		List<File> list = new ArrayList<File>();
		if (null==dir || !dir.isDirectory()) {
			return list;
		}
		
		String[] files = dir.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				File file = new File(dir.getAbsolutePath() + fs + name);
				if (file.isDirectory()) {  // directory is permitted
					return true;
				}
				
				if (null == name || name.lastIndexOf('.') < 0
						|| name.lastIndexOf('.') >= name.length()-1) {
					return false;
				}
				
				String ext = name.substring(name.lastIndexOf('.') + 1);
				for (int i = 0; i < extAccepts.length; i++) {
					String exta = extAccepts[i];
					if (exta.equalsIgnoreCase(ext)) {
						return true;
					}
				}
				return false;
			}
			
		});
		
		String absPath = dir.getAbsolutePath();
		logger.debug(absPath);
		for (int i = 0; i < files.length; i++) {
			String filename = files[i];
			File filea = new File(absPath + fs + filename);
			
			// 如果是文件夹，则进行迭代，否则加入要返回的list
			if (filea!=null && filea.isDirectory()) {
				list.addAll(listFilesInDir(filea));
			} else {
				list.add(filea);
			}
		}
		return list;
	}
	
	/**
	 * 对单独一个文件进行转码。
	 * 
	 * @param srcfile
	 * @param destfile
	 */
	public void transfer(File srcfile, File destfile) throws Exception {
		if (null==srcfile || srcfile.isDirectory() 
				|| null==destfile || destfile.isDirectory()) {
			throw new Exception(FileEncodeTransferTool.EXP_INFO);
		}
		OutputStream os = null;
		BufferedWriter bw = null;
		
		InputStream is = null;
		BufferedReader br = null;
		
		try {
			if ( !destfile.exists() ) {
				destfile.createNewFile();
			}
			os = new FileOutputStream(destfile);
			bw = new BufferedWriter(new OutputStreamWriter(os, destEncoding));
			is = new FileInputStream(srcfile);
			br = new BufferedReader(new InputStreamReader(is, srcEncoding));

			char[] buffer = new char[4096];
			int len;
			while ((len = br.read(buffer)) != -1) {
				bw.write(buffer, 0, len);
			}
			bw.flush();
			
			logger.info("Transfered file: " + destfile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw!=null) {
				try { bw.close(); } catch(Exception ex) {}
			}
			if (os!=null) {
				try { os.close(); } catch(Exception ex) {}
			}
			if (br!=null) {
				try { br.close(); } catch(Exception ex) {}
			}
			if (is!=null) {
				try { is.close(); } catch(Exception ex) {}
			}
		}
	}
	
	/**
	 * 对单独一个文件进行转码。
	 * 
	 * @param srcFilePath
	 * @param destFilePath
	 */
	public void transfer(String srcFilePath, String destFilePath) throws Exception {
		File srcfile = new File(srcFilePath);
		File destfile = new File(destFilePath);
		
		if (null==srcfile || srcfile.isDirectory() 
				|| null==destfile || destfile.isDirectory()) {
			throw new Exception(FileEncodeTransferTool.EXP_INFO);
		}
		
		transfer(srcfile, destfile);
	}
	
	public String[] getExtAccepts() {
		return extAccepts;
	}

	public void setExtAccepts(String[] extAccepts) {
		this.extAccepts = extAccepts;
	}
	
	public void setSrcEncoding(String srcEncoding) {
		this.srcEncoding = srcEncoding;
	}
	
	public void setDestEncoding(String destEncoding) {
		this.destEncoding = destEncoding;
	}
}
