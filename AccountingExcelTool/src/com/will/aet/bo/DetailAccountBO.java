/**
 * 
 */
package com.will.aet.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.will.aet.common.bo.BaseBO;
import com.will.aet.common.util.StaticVariables;
import com.will.aet.dao.AccountItemDAO;
import com.will.aet.dao.DiaoBoDAO;
import com.will.aet.dao.LingLiaoDAO;
import com.will.aet.dao.ShouLiaoDAO;
import com.will.aet.dao.YuMiaoDAO;
import com.will.aet.models.AccountItem;
import com.will.aet.models.InvoiceSubItem;
import com.will.aet.models.invoiceitems.DiaoBoItem;
import com.will.aet.models.invoiceitems.LingLiaoItem;
import com.will.aet.models.invoiceitems.ShouLiaoItem;
import com.will.aet.models.invoiceitems.YuMiaoItem;
import com.will.aet.models.invoicesubitem.FullInvcSubItem;
import com.will.aet.models.invoicesubitem.SimpleInvcSubItem;

/**
 * @author Will
 * @version 2010-7-12
 *
 */
public class DetailAccountBO extends BaseBO {
	private static Logger logger = Logger.getLogger(DetailAccountBO.class.getName());
	
	public DetailAccountBO() {
		// NOP
	}
	
	public void generateDetailAcnt(Workbook fromWb, Workbook toWb) {
		Sheet shtYumiao = fromWb.getSheet(StaticVariables.SHEETNAME_YuMiaoFangHuShouJu);
		Sheet shtShouLiao = fromWb.getSheet(StaticVariables.SHEETNAME_ShouLiaoDan);
		Sheet shtLingLiao = fromWb.getSheet(StaticVariables.SHEETNAME_LingLiaoDan);
		Sheet shtDiaoBo = fromWb.getSheet(StaticVariables.SHEETNAME_CaiLiaoDiaoBoDan);
		
		List<AccountItem> list = new ArrayList<AccountItem>();
		
		// ��������ź��վݣ��������ʼ�¼
		if (null == shtYumiao) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_YuMiaoFangHuShouJu + "�Ĺ�����");
		} else {
			list.addAll( this.getAcntItemListFromYumiao(shtYumiao) );
		}
		
		// �������ϵ����������ʼ�¼
		if (null == shtShouLiao) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_ShouLiaoDan + "�Ĺ�����");
		} else {
			list.addAll( this.getAcntItemListFromShouLiao(shtShouLiao) );
		}

		// �������ϵ����������ʼ�¼
		if (null == shtLingLiao) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_LingLiaoDan + "�Ĺ�����");
		} else {
			list.addAll( this.getAcntItemListFromLingLiao(shtLingLiao) );
		}

		// �������ϵ����������ʼ�¼
		if (null == shtDiaoBo) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_CaiLiaoDiaoBoDan + "�Ĺ�����");
		} else {
			list.addAll( this.getAcntItemListFromDiaoBo(shtDiaoBo) );
		}

		AccountItemDAO acntItemDAO = new AccountItemDAO();
		double initStockCount = 0;
		double initStockMoney = 0;
		int startRow;
		Map<String, Integer> curRowMap = new HashMap<String, Integer>();
		for (AccountItem item : list) {
			// �����Ӧ����ϸSheet�Ƿ��Ѿ����ڣ���������ڣ��򴴽�һ��
			String sheetname = StaticVariables.SHEETNAME_MingXiZhang + "("
					+ item.getProdName() + ")";
			Sheet shtDetail = toWb.getSheet(sheetname);
			if (null == shtDetail) {
				shtDetail = this.createDetailSheet(toWb, sheetname, item.getProdName(),
						item.getSerialCode(), item.getUnitCode());
				curRowMap.put(item.getProdName(), new Integer(6));
				startRow = 6;
				initStockCount = 0;
				initStockMoney = 0;
			} else {
				Integer intStartRow = curRowMap.get(item.getProdName());
				intStartRow = (null == intStartRow) ? new Integer(6) : intStartRow;
				startRow = intStartRow.intValue();
				initStockCount = acntItemDAO.getStockCount(shtDetail, startRow-1);
				initStockMoney = acntItemDAO.getStockMoney(shtDetail, startRow-1);
			}
			item.setInitStockCount(initStockCount);
			item.setInitStockMoney(initStockMoney);
			
			acntItemDAO.insertDetailAcntRcd(shtDetail, item, startRow);
			
			curRowMap.put(item.getProdName(), new Integer(startRow+1));
		}
	}
	
	public List<AccountItem> getAcntItemListFromYumiao(Sheet sheet) {
		List<AccountItem> list = new ArrayList<AccountItem>();
		int addStep = StaticVariables.YuMiaoReceiptHeight;
		int totalRows = sheet.getPhysicalNumberOfRows();
		YuMiaoDAO dao = new YuMiaoDAO();
		
		for (int i = 1; i < totalRows; i+=addStep) {
			YuMiaoItem yuMiaoItem = dao.getYuMiaoItem(sheet, i);
			
			for (InvoiceSubItem invoiceSubItem : yuMiaoItem.getInvoiceSubItems()) {
				FullInvcSubItem subitem = (FullInvcSubItem) invoiceSubItem;
				
				AccountItem accountItemIn = new AccountItem();
				AccountItem accountItemOut = new AccountItem();
				
				accountItemIn.setProdName( subitem.getProdName() );
				accountItemIn.setSerialCode( subitem.getSerialCode() );
				accountItemIn.setUnitCode( subitem.getUnitCode() );
				accountItemIn.setDateYear( yuMiaoItem.getDateYear() );
				accountItemIn.setDateMonth( yuMiaoItem.getDateMonth() );
				accountItemIn.setDateDay( yuMiaoItem.getDateDay() );
				accountItemIn.setCategory( yuMiaoItem.getCategory() );
				accountItemIn.setSerialno( yuMiaoItem.getSerialno() );
				accountItemIn.setSummary( yuMiaoItem.getSummary() );
				accountItemIn.setInCount( subitem.getAmount() );
				accountItemIn.setInUnitPrice( subitem.getMoneyUnitPrice() );
				accountItemIn.setInMoney( subitem.getMoneyAmount() );
				
				accountItemOut.setProdName( subitem.getProdName() );
				accountItemOut.setSerialCode( subitem.getSerialCode() );
				accountItemOut.setUnitCode( subitem.getUnitCode() );
				accountItemOut.setDateYear( yuMiaoItem.getDateYear() );
				accountItemOut.setDateMonth( yuMiaoItem.getDateMonth() );
				accountItemOut.setDateDay( yuMiaoItem.getDateDay() );
				accountItemOut.setCategory( yuMiaoItem.getCategory() );
				accountItemOut.setSerialno( yuMiaoItem.getSerialno() );
				accountItemOut.setSummary( yuMiaoItem.getRemark() );
				accountItemOut.setOutCount( subitem.getAmount() );
				accountItemOut.setOutUnitPrice( subitem.getOrigMoneyUnitPrice() );
				accountItemOut.setOutMoney( subitem.getOrigMoneyAmount() );
				
				list.add(accountItemIn);
				list.add(accountItemOut);
			}
		}
		
		return list;
	}
	
	public List<AccountItem> getAcntItemListFromShouLiao(Sheet sheet) {
		List<AccountItem> list = new ArrayList<AccountItem>();
		int addStep = StaticVariables.ShouLiaoListHeight;
		int totalRows = sheet.getPhysicalNumberOfRows();
		ShouLiaoDAO dao = new ShouLiaoDAO();
		
		for (int i = 1; i < totalRows; i+=addStep) {
			ShouLiaoItem shouLiaoItem = dao.getAcntItemFromShouLiao(sheet, i);
			
			for (InvoiceSubItem invoiceSubItem : shouLiaoItem.getInvoiceSubItems()) {
				FullInvcSubItem subitem = (FullInvcSubItem) invoiceSubItem;
				AccountItem accountItem = new AccountItem();

				accountItem.setProdName( subitem.getProdName() );
				accountItem.setSerialCode( subitem.getSerialCode() );
				accountItem.setUnitCode( subitem.getUnitCode() );
				accountItem.setDateYear( shouLiaoItem.getDateYear() );
				accountItem.setDateMonth( shouLiaoItem.getDateMonth() );
				accountItem.setDateDay( shouLiaoItem.getDateDay() );
				accountItem.setCategory( shouLiaoItem.getCategory() );
				accountItem.setSerialno( shouLiaoItem.getSerialno() );
				accountItem.setSummary( shouLiaoItem.getSummary() );
				accountItem.setInCount( subitem.getAmount() );
				accountItem.setInUnitPrice( subitem.getMoneyUnitPrice() );
				accountItem.setInMoney( subitem.getMoneyAmount() );
				
				list.add(accountItem);
			}
		}
		
		return list;
	}
	
	public List<AccountItem> getAcntItemListFromLingLiao(Sheet sheet) {
		List<AccountItem> list = new ArrayList<AccountItem>();
		int addStep = StaticVariables.LingLiaoListHeight;
		int totalRows = sheet.getPhysicalNumberOfRows();
		LingLiaoDAO dao = new LingLiaoDAO();
		
		for (int i = 1; i < totalRows; i+=addStep) {
			LingLiaoItem lingLiaoItem = dao.getAcntItemFromLingLiao(sheet, i);
			
			for (InvoiceSubItem invoiceSubItem : lingLiaoItem.getInvoiceSubItems()) {
				SimpleInvcSubItem subitem = (SimpleInvcSubItem) invoiceSubItem;
				AccountItem accountItem = new AccountItem();

				accountItem.setProdName( subitem.getProdName() );
				accountItem.setSerialCode( subitem.getSerialCode() );
				accountItem.setUnitCode( subitem.getUnitCode() );
				accountItem.setDateYear( lingLiaoItem.getDateYear() );
				accountItem.setDateMonth( lingLiaoItem.getDateMonth() );
				accountItem.setDateDay( lingLiaoItem.getDateDay() );
				accountItem.setCategory( lingLiaoItem.getCategory() );
				accountItem.setSerialno( lingLiaoItem.getSerialno() );
				accountItem.setSummary( lingLiaoItem.getSummary() );
				accountItem.setOutCount( subitem.getAmount() );
				accountItem.setOutUnitPrice( subitem.getUnitPrice() );
				accountItem.setOutMoney( subitem.getMoneyAmount() );
				
				list.add(accountItem);
			}
		}
		
		return list;
	}
	
	public List<AccountItem> getAcntItemListFromDiaoBo(Sheet sheet) {
		List<AccountItem> list = new ArrayList<AccountItem>();
		int addStep = StaticVariables.CaiLiaoDiaoBoListHeight;
		int totalRows = sheet.getPhysicalNumberOfRows();
		DiaoBoDAO dao = new DiaoBoDAO();
		
		for (int i = 1; i < totalRows; i+=addStep) {
			DiaoBoItem diaoBoItem = dao.getAcntItemFromDiaoBo(sheet, i);
			
			for (InvoiceSubItem invoiceSubItem : diaoBoItem.getInvoiceSubItems()) {
				SimpleInvcSubItem subitem = (SimpleInvcSubItem) invoiceSubItem;
				AccountItem accountItem = new AccountItem();
				
				accountItem.setProdName( subitem.getProdName() );
				accountItem.setSerialCode( subitem.getSerialCode() );
				accountItem.setUnitCode( subitem.getUnitCode() );
				accountItem.setDateYear( diaoBoItem.getDateYear() );
				accountItem.setDateMonth( diaoBoItem.getDateMonth() );
				accountItem.setDateDay( diaoBoItem.getDateDay() );
				accountItem.setCategory( diaoBoItem.getCategory() );
				accountItem.setSerialno( diaoBoItem.getSerialno() );
				accountItem.setSummary( diaoBoItem.getSummary() );
				accountItem.setOutCount( subitem.getAmount() );
				accountItem.setOutUnitPrice( subitem.getUnitPrice() );
				accountItem.setOutMoney( subitem.getMoneyAmount() );
				
				list.add(accountItem);
			}
		}
		
		return list;
	}
	
	/**
	 * ����һ����ϸ��
	 * 
	 * @param workbook
	 * @param shtName
	 * @param prodName
	 * @param serialCode
	 * @param unitCode
	 * @return
	 */
	public Sheet createDetailSheet(Workbook workbook, String shtName,
			String prodName, String serialCode, String unitCode) {
		Sheet sheet = workbook.createSheet(shtName);
		
		Row row = sheet.createRow(0);
		Cell cellTitle = row.createCell(6);
		cellTitle.setCellValue("������ϸ��");
		// �ϲ���Ԫ��
		sheet.addMergedRegion( CellRangeAddress.valueOf("$G$1:$L$1") );
		row.createCell(12).setCellValue("Ʒ��");
		row.createCell(13).setCellValue(prodName);
		
		row = sheet.createRow(1);
		row.createCell(0).setCellValue("���");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$A$2:$B$2") );
		row.createCell(2).setCellValue(serialCode);
		sheet.addMergedRegion( CellRangeAddress.valueOf("$C$2:$F$2") );
		row.createCell(11).setCellValue( "������λ" );
		sheet.addMergedRegion( CellRangeAddress.valueOf("$L$2:$M$2") );
		row.createCell(13).setCellValue(unitCode);
		
		row = sheet.createRow(2);
		row.createCell(0).setCellValue("����");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$A$3:$C$3") );
		row.createCell(3).setCellValue("���");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$D$3:$D$4") );
		row.createCell(4).setCellValue("����");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$E$3:$E$4") );
		row.createCell(5).setCellValue("ժҪ");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$F$3:$F$4") );
		row.createCell(6).setCellValue("������");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$G$3:$I$3") );
		row.createCell(9).setCellValue("������");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$J$3:$L$3") );
		row.createCell(12).setCellValue("�����");
		sheet.addMergedRegion( CellRangeAddress.valueOf("$M$3:$O$3") );
		
		row = sheet.createRow(3);
		row.createCell(0).setCellValue("��");
		row.createCell(1).setCellValue("��");
		row.createCell(2).setCellValue("��");
		row.createCell(6).setCellValue("����");
		row.createCell(7).setCellValue("����");
		row.createCell(8).setCellValue("���");
		row.createCell(9).setCellValue("����");
		row.createCell(10).setCellValue("����");
		row.createCell(11).setCellValue("���");
		row.createCell(12).setCellValue("����");
		row.createCell(13).setCellValue("����");
		row.createCell(14).setCellValue("���");

		row = sheet.createRow(4);
		row.createCell(5).setCellValue("�ڳ����");
		row.createCell(14).setCellValue(new Double(0).doubleValue());
		
		return sheet;
	}
}
