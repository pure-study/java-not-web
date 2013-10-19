/**
 * 
 */
package com.will.aet.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.will.aet.common.dao.BaseDAO;
import com.will.aet.common.util.ExcelParseUtil;
import com.will.aet.common.util.StaticMethods;
import com.will.aet.models.AccountItem;

/**
 * @author Will
 * @version 2010-7-12
 *
 */
public class AccountItemDAO extends BaseDAO {
	/**
	 * 
	 * @param sheet
	 * @param rowIndex 从1开始索引
	 * @return
	 */
	public AccountItem getAccountItem(Sheet sheet, int rowIndex) {
		AccountItem item = new AccountItem();
		rowIndex = (rowIndex <= 0) ? 1 : rowIndex;
		String value = "";
		
		value = ExcelParseUtil.getSpecCellValue(sheet, "A" + rowIndex);
		item.setDateYear( StaticMethods.null2int(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "B" + rowIndex);
		item.setDateMonth( StaticMethods.null2int(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "C" + rowIndex);
		item.setDateDay( StaticMethods.null2int(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "D" + rowIndex);
		item.setCategory( StaticMethods.null2String(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "E" + rowIndex);
		item.setSerialno( StaticMethods.null2String(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "F" + rowIndex);
		item.setSummary( StaticMethods.null2String(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "G" + rowIndex);
		item.setInCount( StaticMethods.null2double(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "H" + rowIndex);
		item.setInUnitPrice( StaticMethods.null2double(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "I" + rowIndex);
		item.setInMoney( StaticMethods.null2double(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "J" + rowIndex);
		item.setOutCount( StaticMethods.null2double(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "K" + rowIndex);
		item.setOutUnitPrice( StaticMethods.null2double(value) );
		value = ExcelParseUtil.getSpecCellValue(sheet, "L" + rowIndex);
		item.setOutMoney( StaticMethods.null2double(value) );
		
		return item;
	}
	
	/**
	 * 
	 * @param sheet
	 * @param rowIndex 从1开始索引
	 * @return
	 */
	public double getStockCount(Sheet sheet, int rowIndex) {
		rowIndex = (rowIndex <= 0) ? 1 : rowIndex;
		String value = ExcelParseUtil.getSpecCellValue(sheet, "M" + rowIndex);
		return StaticMethods.null2double(value);
	}
	
	/**
	 * 
	 * @param sheet
	 * @param rowIndex 从1开始索引
	 * @return
	 */
	public double getStockMoney(Sheet sheet, int rowIndex) {
		rowIndex = (rowIndex <= 0) ? 1 : rowIndex;
		String value = ExcelParseUtil.getSpecCellValue(sheet, "O" + rowIndex);
		return StaticMethods.null2double(value);
	}
	
	/**
	 * 插入一条明细帐记录。
	 * 
	 * @param sheet 总帐sheet
	 * @param item 总帐记录
	 * @param rowIndex 从1开始索引
	 */
	public void insertDetailAcntRcd(Sheet sheet, AccountItem item, int rowIndex) {
		rowIndex = (rowIndex <= 0) ? 0 : (rowIndex - 1);
//		CreationHelper creationHelper = sheet.getWorkbook().getCreationHelper();
		
		Row row = sheet.createRow(rowIndex);
		row.createCell(0).setCellValue( item.getDateYear() );
//		row.createCell(0).setCellValue( creationHelper.createRichTextString("Test Text") );
		row.createCell(1).setCellValue( item.getDateMonth() );
		row.createCell(2).setCellValue( item.getDateDay() );
		row.createCell(3).setCellValue( item.getCategory() );
		row.createCell(4).setCellValue( item.getSerialno() );
		row.createCell(5).setCellValue( item.getSummary() );
		row.createCell(6).setCellValue( item.getInCount() );
		row.createCell(7).setCellValue( item.getInUnitPrice() );
		row.createCell(8).setCellValue( item.getInMoney() );
		row.createCell(9).setCellValue( item.getOutCount() );
		row.createCell(10).setCellValue( item.getOutUnitPrice() );
		row.createCell(11).setCellValue( item.getOutMoney() );
		row.createCell(12).setCellValue( item.getStockCount() );
		row.createCell(13).setCellValue( item.getStockUnitPrice() );
		row.createCell(14).setCellValue( item.getStockMoney() );
	}
	
	/**
	 * 插入一条总帐记录。
	 * 
	 * @param sheet 总帐sheet
	 * @param item 总帐记录
	 * @param rowIndex 从1开始索引
	 */
	public void insertTotalAcntRcd(Sheet sheet, AccountItem item, int rowIndex) {
		rowIndex = (rowIndex <= 0) ? 0 : (rowIndex - 1);
//		CreationHelper creationHelper = sheet.getWorkbook().getCreationHelper();
		
		Row row = sheet.createRow(rowIndex);
		row.createCell(0).setCellValue( item.getDateYear() );
//		row.createCell(0).setCellValue( creationHelper.createRichTextString("Test Text") );
		row.createCell(1).setCellValue( item.getDateMonth() );
		row.createCell(2).setCellValue( item.getDateDay() );
		row.createCell(3).setCellValue( item.getCategory() );
		row.createCell(4).setCellValue( item.getSerialno() );
		row.createCell(5).setCellValue( item.getSummary() );
		row.createCell(8).setCellValue( item.getInMoney() );
		row.createCell(11).setCellValue( item.getOutMoney() );
		row.createCell(14).setCellValue( item.getStockMoney() );
	}
}
