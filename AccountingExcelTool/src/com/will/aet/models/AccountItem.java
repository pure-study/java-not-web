/**
 * 
 */
package com.will.aet.models;

import com.will.aet.common.model.BaseModel;

/**
 * @author Will
 * @version 2010-7-8
 *
 */
public class AccountItem extends BaseModel {
	// Ʒ��
	private String prodName;
	
	// ���
	private String serialCode;
	
	// ������λ
	private String unitCode;

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

	// ������-����
	private double inCount;

	// ������-����
	private double inUnitPrice;

	// ������-���
	private double inMoney;

	// ������-����
	private double outCount;

	// ������-����
	private double outUnitPrice;

	// ������-���
	private double outMoney;

	// �����-����
	private double stockCount;

	// �����-����
	private double stockUnitPrice;

	// �����-���
	private double stockMoney;
	
	// ��ʼ���-����
	private double initStockCount;

	// ��ʼ���-���
	private double initStockMoney;
	
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

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

	public double getInCount() {
		return inCount;
	}

	public void setInCount(double inCount) {
		this.inCount = inCount;
	}

	public double getInUnitPrice() {
		return inUnitPrice;
	}

	public void setInUnitPrice(double inUnitPrice) {
		this.inUnitPrice = inUnitPrice;
	}

	public double getInMoney() {
		return inMoney;
	}

	public void setInMoney(double inMoney) {
		this.inMoney = inMoney;
	}

	public double getOutCount() {
		return outCount;
	}

	public void setOutCount(double outCount) {
		this.outCount = outCount;
	}

	public double getOutUnitPrice() {
		return outUnitPrice;
	}

	public void setOutUnitPrice(double outUnitPrice) {
		this.outUnitPrice = outUnitPrice;
	}

	public double getOutMoney() {
		return outMoney;
	}

	public void setOutMoney(double outMoney) {
		this.outMoney = outMoney;
	}

	public double getStockCount() {
		stockCount = initStockCount + inCount - outCount;
		return stockCount;
	}

//	public void setStockCount(double stockCount) {
//		this.stockCount = stockCount;
//	}

	public double getStockUnitPrice() {
		if (0 == this.getStockCount()) {
			stockUnitPrice = 0;
		} else {
			stockUnitPrice = Math.abs( this.getStockMoney() / this.getStockCount() );
		}
		return stockUnitPrice;
	}

//	public void setStockUnitPrice(double stockUnitPrice) {
//		this.stockUnitPrice = stockUnitPrice;
//	}

	public double getStockMoney() {
		stockMoney = initStockMoney + inMoney - outMoney;
		return stockMoney;
	}

//	public void setStockMoney(double stockMoney) {
//		this.stockMoney = stockMoney;
//	}
	
	public double getInitStockCount() {
		return initStockCount;
	}

	public void setInitStockCount(double initStockCount) {
		this.initStockCount = initStockCount;
	}
	
	public double getInitStockMoney() {
		return initStockMoney;
	}

	public void setInitStockMoney(double initStockMoney) {
		this.initStockMoney = initStockMoney;
	}
	
}
