/**
 * 
 */
package com.will.aettest.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.will.aet.bo.DetailAccountBO;
import com.will.aet.bo.SummaryAccountBO;
import com.will.aet.common.util.ExcelParseUtil;
import com.will.aet.common.util.StaticMethods;
import com.will.aet.common.util.StaticVariables;
import com.will.aet.dao.YuMiaoDAO;
import com.will.aet.models.invoiceitems.ShouLiaoItem;
import com.will.aet.models.invoiceitems.YuMiaoItem;

/**
 * @author Will
 * @version 2010-07-07
 *
 */
public class ExcelParseUtilTest {
	private static String filePathName = "F:\\Will\\大山\\材料系统 - test.xls";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test08();
	}
	
	public static void test08() {
		try {
			FileInputStream fis = new FileInputStream(filePathName);
			Workbook wb = new HSSFWorkbook(fis);
			
			SummaryAccountBO summaryAccountBO = new SummaryAccountBO();
			DetailAccountBO detailAccountBO = new DetailAccountBO();
			summaryAccountBO.generateTotalAcnt(wb, wb);
			detailAccountBO.generateDetailAcnt(wb, wb);
			fis.close();
			
			FileOutputStream fos = new FileOutputStream(filePathName);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test07() {
		try {
			FileInputStream fis = new FileInputStream(filePathName);
			Workbook wb = new HSSFWorkbook(fis);
			
			DetailAccountBO detailAccountBO = new DetailAccountBO();
			detailAccountBO.generateDetailAcnt(wb, wb);
			fis.close();
			
			FileOutputStream fos = new FileOutputStream(filePathName);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test05() {
		try {
			FileInputStream fis = new FileInputStream(filePathName);
			Workbook wb = new HSSFWorkbook(fis);
			
			SummaryAccountBO summaryAccountBO = new SummaryAccountBO();
			summaryAccountBO.generateTotalAcnt(wb, wb);
			fis.close();
			
			FileOutputStream fos = new FileOutputStream(filePathName);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test06() {
		try {
			FileInputStream fis = new FileInputStream(filePathName);
			Workbook wb = new HSSFWorkbook(fis);
			Sheet shtYumiao = wb.getSheet(StaticVariables.SHEETNAME_YuMiaoFangHuShouJu);
			
			YuMiaoDAO dao = new YuMiaoDAO();
			YuMiaoItem item = dao.getYuMiaoItem(shtYumiao, 1);
			System.out.println(item.toString());
			
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test04() {
		try {
			FileInputStream fis = new FileInputStream(filePathName);
			Workbook wb = new HSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("鱼苗放湖收据");
			
			String value = "";
			value = ExcelParseUtil.getSpecCellValue(sheet, "F3");
			System.out.println(value);
			value = ExcelParseUtil.getSpecCellValue(sheet, "C22");
			System.out.println(value);
			value = ExcelParseUtil.getSpecCellValue(sheet, "C6");
			System.out.println(value);
			
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test03() {
		List<List<String>> list01 = new ArrayList<List<String>>();
		for (int i = 0; i < 5; i++) {
			List<String> list02 = new ArrayList<String>();
			for (int j = 0; j < 5; j++) {
				list02.add(i + "|" + j);
			}
			
			list01.add(list02);
		}
		
		System.out.println(list01.get(3).get(4));
	}
	
	public static void test01() {
		String filepath = "F:\\Will\\大山\\材料系统 - test.xls";
		
		try {
			String[][] dataArr = ExcelParseUtil.getExcelDataBySheetName("鱼苗放湖收据", filepath);
			
			if (null != dataArr) {
				for (int i = 0; i < dataArr.length; i++) {
					for (int j = 0; j < dataArr[i].length; j++) {
						System.out.println(i+"|"+j+" :"+dataArr[i][j]);
					}
					
					System.out.println("=======================");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test02() {
		String filepath = "F:\\Will\\大山\\材料系统 - test.xls";
		
		try {
			List dataList = ExcelParseUtil.getCellContentsBySheetName("鱼苗放湖收据", filepath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
