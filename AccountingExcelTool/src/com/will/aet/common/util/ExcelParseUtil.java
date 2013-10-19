package com.will.aet.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

/**
 * 
 * @author Will
 * @version 2010-07-07
 *
 */
public class ExcelParseUtil {
	public static final String numberWithDecimalPattern = "0.00";
	
	public static final String numberNoDecimalPattern = "0";
	
	public static final String dateFullPattern = "yyyy-MM-dd HH:mm:ss";
	
	public static final String dateOnlyDatePattern = "yyyy-MM-dd";
	
	public static final Format numberWithDecimalFormat = new DecimalFormat(numberWithDecimalPattern);
	
	public static final Format numberNoDecimalFormat = new DecimalFormat(numberNoDecimalPattern);
	
	public static final Format dateFullFormat = new SimpleDateFormat(dateFullPattern);
	
	public static final Format dateOnlyDateFormat = new SimpleDateFormat(dateOnlyDatePattern);
	
	/**
	 * ֱ��ȡĳ��Sheet��ָ����Ԫ���ֵ��
	 * 
	 * @param sheet
	 * @param cellRefName ��Ԫ��ı�ʶ������A1��H12
	 * @return ����ȥ����β�ո����ַ���ֵ
	 */
	public static String getSpecCellValue(Sheet sheet, String cellRefName) {
		String value = "";
		try {
			CellReference cellReference = new CellReference(cellRefName);
			Row row = sheet.getRow(cellReference.getRow());
			Cell cell = row.getCell(cellReference.getCol());
			
			value = convertCellValue2StringNoExp(cell);
			value = (null == value) ? "" : value.trim();
		} catch (Exception e) {
			e.printStackTrace();
			value = "";
		}
		return value;
	}
	
	/**
	 * ����ĳ��CELL_TYPE_FORMULA��Ԫ���ֵ��
	 * 
	 * @param sheet
	 * @param cellRefName
	 * @return
	 * @throws Exception
	 */
	public static String getSpecFormulaCellValue(Sheet sheet, String cellRefName) throws Exception {
		String value = "";
		Workbook wb = sheet.getWorkbook();
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		
		CellReference cellReference = new CellReference(cellRefName);
		Row row = sheet.getRow(cellReference.getRow());
		Cell cell = row.getCell(cellReference.getCol());
		
		CellValue cellValue = evaluator.evaluate(cell);
		
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			value = String.valueOf( cellValue.getBooleanValue() );
			break;
		case Cell.CELL_TYPE_NUMERIC:
			// TODO: ���ദ�����ڸ�ʽ��ƽ��������
			value = String.valueOf( cellValue.getNumberValue() );
			break;
		case Cell.CELL_TYPE_STRING:
			value = cellValue.getStringValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		case Cell.CELL_TYPE_ERROR:
			value = "";
			break;

		// CELL_TYPE_FORMULA will never happen
		case Cell.CELL_TYPE_FORMULA:
			break;
		}
		
		return value;
	}
	
	/**
	 * ������SHEET�����ݽ�����һ��List�
	 * 
	 * List��ÿ��������Ȼ��һ��List����ʾһ�е����ݡ����List���ÿ���������һ��String�ַ�����
	 * ��ʾÿ����Ԫ������ݡ�
	 * 
	 * @param sheetName
	 * @param filePathName
	 * @return
	 * @throws Exception
	 */
	public static synchronized List getCellContentsBySheetName(
			String sheetName, String filePathName) throws Exception {
		try {
			List<List<String>> excelData = new ArrayList<List<String>>();
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePathName));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			// �������ƻ��ĳ��������
			HSSFSheet sheet = wb.getSheet(sheetName);
			if (null == sheet) {
				throw new Exception("û���ҵ�����Ϊ *" + sheetName + "* �Ĺ�����");
			}
			
			for (Row row : sheet) {
				List<String> rowsList = new ArrayList<String>();
				for (Cell cell : row) {
					String value = convertCellValue2StringNoExp(cell);
					
					rowsList.add(value);
				}
				
				excelData.add(rowsList);
			}
			
			return excelData;
		} catch (IOException e) {
			throw new Exception(filePathName + "�ļ�������");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("����excel���ݳ���");
		}
	}
	
	/**
	 * ��һ��Cell�е�ֵ������һ��String����ȡ������
	 * 
	 * ������Cell�е�ֵ��һ����ʽ���򷵻������ʽ����Ľ����
	 * 
	 * ��������쳣�����᷵һ�����ַ�������������쳣�����׳������ô˷����ĵط���
	 * 
	 * @param cell
	 * @return
	 */
	public static String convertCellValue2StringNoExp(Cell cell) {
		return convertCellValue2StringNoExp(cell, cell.getCellType());
	}
	
	/**
	 * ��һ��Cell�е�ֵ������һ��String����ȡ������
	 * 
	 * ������Cell�е�ֵ��һ����ʽ���򷵻������ʽ����Ľ����
	 * 
	 * ��������쳣�����᷵һ�����ַ�������������쳣�����׳������ô˷����ĵط���
	 * 
	 * @param cell
	 * @param cellType
	 * @return
	 */
	private static String convertCellValue2StringNoExp(Cell cell, int cellType) {
		String value = "";
		try {
			CellReference cellRef = new CellReference(cell.getRowIndex(), cell.getColumnIndex());
			System.out.print(cellRef.formatAsString());
			System.out.print(" - ");

			switch (cellType) {
			case Cell.CELL_TYPE_STRING:
				value = cell.getRichStringCellValue().getString();
				System.out.println(value);
				break;
				
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					value = cell.getDateCellValue().toString();
				} else {
					value = String.valueOf( cell.getNumericCellValue() );
				}
				System.out.println(value);
				break;
				
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf( cell.getBooleanCellValue() );
				System.out.println(value);
				break;
				
			case Cell.CELL_TYPE_FORMULA:
//				value = cell.getCellFormula();
				System.out.print(cell.getCellFormula() + " = ");
				value = convertCellValue2StringNoExp(cell, cell.getCachedFormulaResultType());
				break;
				
			case HSSFCell.CELL_TYPE_ERROR:
//				value = "ERROR_" + String.valueOf(cell.getErrorCellValue());
				
				value = "";
				System.out.println(value);
				break;
				
			case HSSFCell.CELL_TYPE_BLANK:
				
			default:
				value = "";
				System.out.println(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
			value = "";
		}
		
		return value;
	}
	
	/**
	 * <p>�÷��������һ�������Ǳ����У����ý��н��������Է��ص������У���һ��ȫ��Ϊ�ա�</p>
	 * 
	 * <p>NOTE: ���ص��ַ������Ѿ�ȥ����ǰ�����Ŀո������ⲿ�ķ��������ٵ���String.trim()�����ˡ�</p>
	 * 
	 * @param sheetName
	 * @param filePathName
	 * @return
	 * @throws Exception
	 */
	public static synchronized String[][] getExcelDataBySheetName(
			String sheetName, String filePathName) throws Exception {
		try {
			String[][] excelData;
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePathName));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
			// �������ƻ��ĳ��������
			HSSFSheet sheet = wb.getSheet(sheetName);
			if (null == sheet) {
				throw new Exception("û���ҵ�����Ϊ *" + sheetName + "* �Ĺ�����");
			}
			// ���sheet������
			int rows = sheet.getPhysicalNumberOfRows();

			HSSFRow rowTitle = sheet.getRow(0);
			if (null == rowTitle) {
				return new String[0][0];
			}
			// ��ñ����е�����
			int cells = rowTitle.getPhysicalNumberOfCells();
			// ��ʼ���������ݵ�����
			excelData = new String[rows][cells];
			for (int r = 1; r < rows; r++) {
				HSSFRow row = sheet.getRow(r);
				if (row != null) {
					for (int c = 0; c < cells; c++) {
						HSSFCell cell = row.getCell(c);
						String value = "";
						if (cell != null) {
							// �жϵ�Ԫ�����ݵ�����
							switch (cell.getCellType()) {

							case HSSFCell.CELL_TYPE_FORMULA:
								System.out.print(cell.getCellFormula());
								switch ( cell.getCachedFormulaResultType() ) {
								case HSSFCell.CELL_TYPE_NUMERIC:
									System.out.print("(CELL_TYPE_NUMERIC)");
									value = new HSSFDataFormatter().formatCellValue(cell, evaluator);// cell.getNumericCellValue();
									break;
								case HSSFCell.CELL_TYPE_STRING:
									System.out.print("(CELL_TYPE_STRING)");
									value = cell.getStringCellValue();
									break;
								case HSSFCell.CELL_TYPE_BOOLEAN:
									System.out.print("(CELL_TYPE_BOOLEAN)");
									value = String.valueOf(cell.getBooleanCellValue());
									break;
								case HSSFCell.CELL_TYPE_ERROR:
									System.out.print("(CELL_TYPE_ERROR)");
									value = "ERROR_" + String.valueOf(cell.getErrorCellValue());
									break;
								default:
									System.out.print("()");
									value = "";
									break;
								}
								System.out.println(" = " + value);
								break;

							case HSSFCell.CELL_TYPE_NUMERIC:
								DecimalFormat formater = new DecimalFormat("0.#");
								double num = cell.getNumericCellValue();
								value = formater.format(num);
								break;

							case HSSFCell.CELL_TYPE_STRING:
								value = cell.getStringCellValue();
								break;

							case HSSFCell.CELL_TYPE_BOOLEAN:
								value = "" + cell.getBooleanCellValue();
								break;

							case HSSFCell.CELL_TYPE_ERROR:
								value = "ERROR_" + String.valueOf(cell.getErrorCellValue());
								break;
								
							case HSSFCell.CELL_TYPE_BLANK:

							default:
								value = "";
								break;
							}
						}
						excelData[r][c] = value.trim();
					}
				}
			}
			return excelData;
		} catch (IOException e) {
			throw new Exception(filePathName + "�ļ�������");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("����excel���ݳ���");
		}
	}
	
	public static int getSheetIndex(String sheetName, String filePathName) throws Exception {
		try {
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
					filePathName));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			return wb.getSheetIndex(sheetName);
		} catch (FileNotFoundException e) {
			throw new Exception("û���ҵ�Excel�ļ���" + filePathName);
		} catch (IOException e) {
			throw e;
		}
	}
}
