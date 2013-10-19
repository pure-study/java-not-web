/**
 * 
 */
package com.will.aet.models.invoiceitems;

import com.will.aet.models.InvoiceItem;

/**
 * @author Will
 * @version 2010-7-8
 *
 */
public class DiaoBoItem extends InvoiceItem {
	// 日期-年
	private int dateYear;

	// 日期-月
	private int dateMonth;

	// 日期-日
	private int dateDay;
	
	// 类别
	private String category;

	// 号数
	private String serialno;

	// 摘要
	private String summary;
	
	// 贷款合计
	private double moneyTotal;
	
	// 备注
	private String remark;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDateYear() {
		return dateYear;
	}

	public void setDateYear(int dateYear) {
		this.dateYear = dateYear;
	}

	public int getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(int dateMonth) {
		this.dateMonth = dateMonth;
	}

	public int getDateDay() {
		return dateDay;
	}

	public void setDateDay(int dateDay) {
		this.dateDay = dateDay;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
