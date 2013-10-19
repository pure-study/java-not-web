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
	// ����-��
	private int dateYear;

	// ����-��
	private int dateMonth;

	// ����-��
	private int dateDay;
	
	// ���
	private String category;

	// ����
	private String serialno;

	// ժҪ
	private String summary;
	
	// ����ϼ�
	private double moneyTotal;
	
	// ��ע
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
