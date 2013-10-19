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
import com.will.aet.models.invoiceitems.LingLiaoItem;
import com.will.aet.models.invoicesubitem.SimpleInvcSubItem;

/**
 * @author Will
 * @version 2010-7-10
 *
 */
public class LingLiaoDAO extends BaseDAO {
	public LingLiaoItem getAcntItemFromLingLiao(Sheet sheet, int startRowIndex) {
		LingLiaoItem item = new LingLiaoItem();
		startRowIndex = (startRowIndex <= 0) ? 0 : (startRowIndex - 1);
		try {
			String value = "";
			value = ExcelParseUtil.getSpecCellValue(sheet, "D" + (startRowIndex+3));  // D3
			item.setDateYear( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "E" + (startRowIndex+3));  // E3
			item.setDateMonth( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "F" + (startRowIndex+3));  // F3
			item.setDateDay( StaticMethods.nullDoubleString2int(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "H" + (startRowIndex+2));  // H2
			item.setCategory( StaticMethods.nullObject2String(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "I" + (startRowIndex+2));  // I2
			item.setSerialno( StaticMethods.nullObject2String(value) );
			
			value = ExcelParseUtil.getSpecCellValue(sheet, "C" + (startRowIndex+18));  // C18
			item.setSummary( StaticMethods.nullObject2String(value) );

			// 下面这个值也可以在后面取InvoiceSubItem的循环里，计算获得
			value = ExcelParseUtil.getSpecCellValue(sheet, "G" + (startRowIndex+16));  // G16
			item.setMoneyTotal( StaticMethods.null2double(value) );

			List<InvoiceSubItem> invoiceSubItems = new ArrayList<InvoiceSubItem>();
			for (int i = 0; i < StaticVariables.SubItemsCnt_LingLiaoDan; i++) {
				int rowIndex = startRowIndex
						+ StaticVariables.SubItemStartRow_LingLiaoDan + i;
				SimpleInvcSubItem subitem = new SimpleInvcSubItem();
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "B" + rowIndex);  // B6
				if (null==value || "".equals(value.trim())) {
					break;  // 如果某行没有填写"编码"，则表示这个单据已经没有明细记录了
				}
				subitem.setSerialCode( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "A" + rowIndex);  // A6
				subitem.setSerialId( StaticMethods.null2int(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "C" + rowIndex);  // C6
				subitem.setProdName( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "D" + rowIndex);  // D6
				subitem.setSpecification( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "E" + rowIndex);  // E6
				subitem.setUnitCode( StaticMethods.null2String(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "F" + rowIndex);  // F6
				subitem.setAmount( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "G" + rowIndex);  // G6
				subitem.setUnitPrice( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "H" + rowIndex);  // H6
				subitem.setMoneyAmount( StaticMethods.null2double(value) );
				
				value = ExcelParseUtil.getSpecCellValue(sheet, "I" + rowIndex);  // I6
				subitem.setRemark( StaticMethods.null2String(value) );
				
				invoiceSubItems.add(subitem);
			}
			item.setInvoiceSubItems(invoiceSubItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return item;
	}
}
