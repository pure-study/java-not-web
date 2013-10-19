/**
 * 
 */
package com.will.aet;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * @author Will
 * @version 2010-7-12
 *
 */
public class ExcelFileFilter extends FileFilter {

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if ( f == null ) {
			return false;
		}
		
		if ( f.isDirectory() ) {
			return true;
		}
		
		String fileName = f.getName();
		int i = fileName.lastIndexOf('.');
		if ( i<=0 || i>=fileName.length()-1 ) {
			return false;
		}
		
		String ext = fileName.substring(i+1).toLowerCase();
		if ("xls".equals(ext) || "xlsx".equals(ext)) {
			return true;
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "ExcelÎÄ¼þ";
	}

}
