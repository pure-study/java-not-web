/**
 * 
 */
package com.will.aet.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;

import com.will.aet.common.dao.BaseDAO;
import com.will.aet.common.util.ExcelParseUtil;
import com.will.aet.common.util.StaticMethods;
import com.will.aet.common.util.StaticVariables;
import com.will.aet.models.InvoiceSubItem;
import com.will.aet.models.invoiceitems.YuMiaoItem;
import com.will.aet.models.invoicesubitem.FullInvcSubItem;

/**
 * @author Will
 * @version 2010-7-10
 *
 */
public class YuMiaoDAO extends BaseDAO {
	public YuMiaoItem getYuMiaoItem(Sheet sheet, int startRowIndex) {
		YuMiaoItem item = new YuMiaoItem();
		startRowIndex = (startRowIndex <= 0) ? 0 : (startRowIndex - 1);
		try {
			String value = "";
			value = ExcelParseUtil.getSpecCellValue(sheet, "F" + (startRowIndex+3));  // F3
			item.setDateYear( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "G" + (startRowIndex+3));  // G3
			item.setDateMonth( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "H" + (startRowIndex+3));  // H3
			item.setDateDay( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "I" + (startRowIndex+2));  // I2
			item.setCategory( StaticMethods.nullObject2String(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "K" + (startRowIndex+2));  // K2
			item.setSerialno( StaticMethods.nullObject2String(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "C" + (startRowIndex+22));  // C22
			item.setSummary( StaticMethods.nullObject2String(value) );

			// 下面这个值也可以在后面取InvoiceSubItem的循环里，计算获得
			value = ExcelParseUtil.getSpecCellValue(sheet, "G" + (startRowIndex+20));  // G20
			item.setMoneyTotal( StaticMethods.null2double(value) );
			
			// 下面这个值也可以在后面取InvoiceSubItem的循环里，计算获得
			value = ExcelParseUtil.getSpecCellValue(sheet, "I" + (startRowIndex+20));  // I20
			item.setOrigMoneyTotal( StaticMethods.null2double(value) );

			// 下面这个值也可以在后面取InvoiceSubItem的循环里，计算获得
			value = ExcelParseUtil.getSpecCellValue(sheet, "K" + (startRowIndex+20));  // K20
			item.setOtherMoneyTotal( StaticMethods.null2double(value) );

			value = ExcelParseUtil.getSpecCellValue(sheet, "M" + (startRowIndex+10));  // M10
			item.setRemark( StaticMethods.nullObject2String(value) );
			
			List<InvoiceSubItem> invoiceSubItems = new ArrayList<InvoiceSubItem>();
			for (int i = 0; i < StaticVariables.SubItemsCnt_YuMiaoFangHuShouJu; i++) {
				int rowIndex = startRowIndex
						+ StaticVariables.SubItemStartRow_YuMiaoFangHuShouJu + i;
				FullInvcSubItem subitem = new FullInvcSubItem();
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "B" + rowIndex);  // B10
				if (null==value || "".equals(value.trim())) {
					break;  // 如果某行没有填写"编码"，则表示这个单据已经没有明细记录了
				}
				subitem.setSerialCode( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "A" + rowIndex);  // A10
				subitem.setSerialId( StaticMethods.null2int(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "C" + rowIndex);  // C10
				subitem.setProdName( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "D" + rowIndex);  // D10
				subitem.setSpecification( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "E" + rowIndex);  // E10
				subitem.setUnitCode( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "F" + rowIndex);  // F10
				subitem.setAmount( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "G" + rowIndex);  // G10
				subitem.setMoneyUnitPrice( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "H" + rowIndex);  // H10
				subitem.setMoneyAmount( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "I" + rowIndex);  // I10
				subitem.setOrigMoneyUnitPrice( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "J" + rowIndex);  // J10
				subitem.setOrigMoneyAmount( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "K" + rowIndex);  // K10
				subitem.setOtherUnitPrice( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "L" + rowIndex);  // L10
				subitem.setOtherAmount( StaticMethods.null2double(value) );
				
//				value = ExcelParseUtil.getSpecCellValue(sheet, "M" + rowIndex);  // M10
				subitem.setRemark( StaticMethods.null2String(item.getRemark()) );
				
				invoiceSubItems.add(subitem);
			}
			item.setInvoiceSubItems(invoiceSubItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
}
