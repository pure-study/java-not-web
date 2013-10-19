/**
 * 
 */
package net.will.common.util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 *
 * @author Will
 * @version 2011-12-5
 */
public class ExcelParseUtilTest {

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#getSpecCellValue(org.apache.poi.ss.usermodel.Sheet, java.lang.String)}.
	 */
	@Test
	@Ignore("not ready")
	public void testGetSpecCellValue() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#getSpecFormulaCellValue(org.apache.poi.ss.usermodel.Sheet, java.lang.String)}.
	 */
	@Test
	@Ignore("not ready")
	public void testGetSpecFormulaCellValue() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#getCellContentsBySheetName(java.lang.String, java.lang.String)}.
	 */
	@Test
	@Ignore("not ready")
	public void testGetCellContentsBySheetName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#convertCellValue2StringNoExp(org.apache.poi.ss.usermodel.Cell)}.
	 */
	@Test
	@Ignore("not ready")
	public void testConvertCellValue2StringNoExp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#getExcelDataBySheetName(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetExcelDataBySheetName() {
		String filepathname = "G:\\tempFile20111202164631109.xls";
		try {
			String[][] data = ExcelParseUtil.getExcelDataBySheetName("taw_material_assets", filepathname);
			assertTrue( data.length == 6 );
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link net.will.common.util.ExcelParseUtil#getSheetIndex(java.lang.String, java.lang.String)}.
	 */
	@Test
	@Ignore("not ready")
	public void testGetSheetIndex() {
		fail("Not yet implemented");
	}

}
