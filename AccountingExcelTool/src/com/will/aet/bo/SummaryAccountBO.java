/**
 * 
 */
package com.will.aet.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import com.will.aet.models.invoiceitems.DiaoBoItem;
import com.will.aet.models.invoiceitems.LingLiaoItem;
import com.will.aet.models.invoiceitems.ShouLiaoItem;
import com.will.aet.models.invoiceitems.YuMiaoItem;

/**
 * @author Will
 * @version 2010-7-9
 *
 */
public class SummaryAccountBO extends BaseBO {
//	private static Log log = LogFactory.getLog(SummaryAccountBO.class);
	private static Logger logger = Logger.getLogger(SummaryAccountBO.class.getName());
	
	public SummaryAccountBO() {
		// NOP
	}
	
	public void generateTotalAcnt(Workbook fromWb, Workbook toWb) {
		Sheet shtYumiao = fromWb.getSheet(StaticVariables.SHEETNAME_YuMiaoFangHuShouJu);
		Sheet shtShouLiao = fromWb.getSheet(StaticVariables.SHEETNAME_ShouLiaoDan);
		Sheet shtLingLiao = fromWb.getSheet(StaticVariables.SHEETNAME_LingLiaoDan);
		Sheet shtDiaoBo = fromWb.getSheet(StaticVariables.SHEETNAME_CaiLiaoDiaoBoDan);
		
		Sheet shtTotalAcnt = toWb.getSheet(StaticVariables.SHEETNAME_ZongZhang);
		if (null == shtTotalAcnt) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_ZongZhang + "�Ĺ�����");
			logger.info("�����Զ�����һ��Ĭ�ϵĹ�����!");
			shtTotalAcnt = this.createTotalSheet(toWb, StaticVariables.SHEETNAME_ZongZhang);
//			return;
		}
		
		double initStockCount = 0;
		double initStockMoney = 832;
		int startRow = 6;
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

		// ���ݲ��ϵ��������������ʼ�¼
		if (null == shtDiaoBo) {
			logger.info("û���ҵ�����Ϊ" + StaticVariables.SHEETNAME_CaiLiaoDiaoBoDan + "�Ĺ�����");
		} else {
			list.addAll( this.getAcntItemListFromDiaoBo(shtDiaoBo) );
		}
		
		AccountItemDAO acntItemDAO = new AccountItemDAO();
		for (AccountItem item : list) {
			item.setInitStockCount(initStockCount);
			item.setInitStockMoney(initStockMoney);
			acntItemDAO.insertTotalAcntRcd(shtTotalAcnt, item, startRow);
			
			startRow++;
			initStockCount = item.getStockCount();
			initStockMoney = item.getStockMoney();
		}
	}
	
	public List<AccountItem> getAcntItemListFromYumiao(Sheet sheet) {
		List<AccountItem> list = new ArrayList<AccountItem>();
		int addStep = StaticVariables.YuMiaoReceiptHeight;
		int totalRows = sheet.getPhysicalNumberOfRows();
		YuMiaoDAO dao = new YuMiaoDAO();
		
		for (int i = 1; i < totalRows; i+=addStep) {
			YuMiaoItem yuMiaoItem = dao.getYuMiaoItem(sheet, i);
			AccountItem accountItemIn = new AccountItem();
			AccountItem accountItemOut = new AccountItem();
			
			accountItemIn.setDateYear( yuMiaoItem.getDateYear() );
			accountItemIn.setDateMonth( yuMiaoItem.getDateMonth() );
			accountItemIn.setDateDay( yuMiaoItem.getDateDay() );
			accountItemIn.setCategory( yuMiaoItem.getCategory() );
			accountItemIn.setSerialno( yuMiaoItem.getSerialno() );
			accountItemIn.setSummary( yuMiaoItem.getSummary() );
			accountItemIn.setInMoney( yuMiaoItem.getMoneyTotal() );
			
			accountItemOut.setDateYear( yuMiaoItem.getDateYear() );
			accountItemOut.setDateMonth( yuMiaoItem.getDateMonth() );
			accountItemOut.setDateDay( yuMiaoItem.getDateDay() );
			accountItemOut.setCategory( yuMiaoItem.getCategory() );
			accountItemOut.setSerialno( yuMiaoItem.getSerialno() );
			accountItemOut.setSummary( yuMiaoItem.getRemark() );
			accountItemOut.setOutMoney( yuMiaoItem.getMoneyTotal() );
			
			list.add(accountItemIn);
			list.add(accountItemOut);
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
			AccountItem accountItem = new AccountItem();
			
			accountItem.setDateYear( shouLiaoItem.getDateYear() );
			accountItem.setDateMonth( shouLiaoItem.getDateMonth() );
			accountItem.setDateDay( shouLiaoItem.getDateDay() );
			accountItem.setCategory( shouLiaoItem.getCategory() );
			accountItem.setSerialno( shouLiaoItem.getSerialno() );
			accountItem.setSummary( shouLiaoItem.getSummary() );
			accountItem.setInMoney( shouLiaoItem.getMoneyTotal() );
			
//			try {
//				BeanUtils.copyProperties(accountItem, shouLiaoItem);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
			list.add(accountItem);
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
			AccountItem accountItem = new AccountItem();
			
			accountItem.setDateYear( lingLiaoItem.getDateYear() );
			accountItem.setDateMonth( lingLiaoItem.getDateMonth() );
			accountItem.setDateDay( lingLiaoItem.getDateDay() );
			accountItem.setCategory( lingLiaoItem.getCategory() );
			accountItem.setSerialno( lingLiaoItem.getSerialno() );
			accountItem.setSummary( lingLiaoItem.getSummary() );
			accountItem.setOutMoney( lingLiaoItem.getMoneyTotal() );
			
			list.add(accountItem);
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
			AccountItem accountItem = new AccountItem();
			
			accountItem.setDateYear( diaoBoItem.getDateYear() );
			accountItem.setDateMonth( diaoBoItem.getDateMonth() );
			accountItem.setDateDay( diaoBoItem.getDateDay() );
			accountItem.setCategory( diaoBoItem.getCategory() );
			accountItem.setSerialno( diaoBoItem.getSerialno() );
			accountItem.setSummary( diaoBoItem.getSummary() );
			accountItem.setOutMoney( diaoBoItem.getMoneyTotal() );
			
			list.add(accountItem);
		}
		
		return list;
	}
	
	/**
	 * ����һ������
	 * 
	 * @param workbook
	 * @param shtName
	 * @param prodName
	 * @param serialCode
	 * @param unitCode
	 * @return
	 */
	public Sheet createTotalSheet(Workbook workbook, String shtName) {
		Sheet sheet = workbook.createSheet(shtName);
		
		Row row = sheet.createRow(0);
		Cell cellTitle = row.createCell(6);
		cellTitle.setCellValue("������ϸ��");
		// �ϲ���Ԫ��
		sheet.addMergedRegion( CellRangeAddress.valueOf("$G$1:$L$1") );
		
		row = sheet.createRow(1);
		
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
