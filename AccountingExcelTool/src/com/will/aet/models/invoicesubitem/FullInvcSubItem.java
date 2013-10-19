/**
 * 
 */
package com.will.aet.models.invoicesubitem;

import com.will.aet.models.InvoiceSubItem;

/**
 * @author Will
 * @version 2010-7-11
 *
 */
public class FullInvcSubItem extends InvoiceSubItem {
	private double moneyUnitPrice;
	
	private double moneyAmount;
	
	private double origMoneyUnitPrice;
	
	private double origMoneyAmount;
	
	private double otherUnitPrice;
	
	private double otherAmount;

	/**
	 * 货款合计-单价
	 */
	public double getMoneyUnitPrice() {
		return moneyUnitPrice;
	}

	public void setMoneyUnitPrice(double moneyUnitPrice) {
		this.moneyUnitPrice = moneyUnitPrice;
	}

	/**
	 * 货款合计-金额
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	/**
	 * 原货款-单价
	 */
	public double getOrigMoneyUnitPrice() {
		return origMoneyUnitPrice;
	}

	public void setOrigMoneyUnitPrice(double origMoneyUnitPrice) {
		this.origMoneyUnitPrice = origMoneyUnitPrice;
	}

	/**
	 * 原货款-金额
	 */
	public double getOrigMoneyAmount() {
		return origMoneyAmount;
	}

	public void setOrigMoneyAmount(double origMoneyAmount) {
		this.origMoneyAmount = origMoneyAmount;
	}

	/**
	 * 其他费用-单价
	 */
	public double getOtherUnitPrice() {
		return otherUnitPrice;
	}

	public void setOtherUnitPrice(double otherUnitPrice) {
		this.otherUnitPrice = otherUnitPrice;
	}

	/**
	 * 其他费用-金额
	 */
	public double getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	
}
