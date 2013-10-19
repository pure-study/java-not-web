/**
 * 
 */
package com.will.aet.common.util;

/**
 * @author Will
 * @version 2010-7-10
 *
 */
public interface StaticVariables {
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// 每类单据所占Excel的行数
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final int YuMiaoReceiptHeight = 23;
	
	public static final int ShouLiaoListHeight = 22;
	
	public static final int LingLiaoListHeight = 19;
	
	public static final int CaiLiaoDiaoBoListHeight = 19;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// 每类单据中，第一条明细记录的起始行
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final int SubItemStartRow_YuMiaoFangHuShouJu = 10;
	
	public static final int SubItemStartRow_ShouLiaoDan = 10;
	
	public static final int SubItemStartRow_LingLiaoDan = 6;
	
	public static final int SubItemStartRow_CaiLiaoDiaoBoDan = 6;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// 每类单据最多可以容纳多少条明细记录
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final int SubItemsCnt_YuMiaoFangHuShouJu = 10;
	
	public static final int SubItemsCnt_ShouLiaoDan = 10;
	
	public static final int SubItemsCnt_LingLiaoDan = 10;
	
	public static final int SubItemsCnt_CaiLiaoDiaoBoDan = 10;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static final String SHEETNAME_YuMiaoFangHuShouJu = "鱼苗放湖收据";
	public static final String SHEETNAME_ShouLiaoDan = "收料单";
	public static final String SHEETNAME_LingLiaoDan = "领料单";
	public static final String SHEETNAME_CaiLiaoDiaoBoDan = "材料调拨单";
	public static final String SHEETNAME_ZongZhang = "总帐";
	public static final String SHEETNAME_MingXiZhang = "明细帐";
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
}
