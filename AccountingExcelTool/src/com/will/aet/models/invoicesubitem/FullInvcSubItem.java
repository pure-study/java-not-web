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
	 * ����ϼ�-����
	 */
	public double getMoneyUnitPrice() {
		return moneyUnitPrice;
	}

	public void setMoneyUnitPrice(double moneyUnitPrice) {
		this.moneyUnitPrice = moneyUnitPrice;
	}

	/**
	 * ����ϼ�-���
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	/**
	 * ԭ����-����
	 */
	public double getOrigMoneyUnitPrice() {
		return origMoneyUnitPrice;
	}

	public void setOrigMoneyUnitPrice(double origMoneyUnitPrice) {
		this.origMoneyUnitPrice = origMoneyUnitPrice;
	}

	/**
	 * ԭ����-���
	 */
	public double getOrigMoneyAmount() {
		return origMoneyAmount;
	}

	public void setOrigMoneyAmount(double origMoneyAmount) {
		this.origMoneyAmount = origMoneyAmount;
	}

	/**
	 * ��������-����
	 */
	public double getOtherUnitPrice() {
		return otherUnitPrice;
	}

	public void setOtherUnitPrice(double otherUnitPrice) {
		this.otherUnitPrice = otherUnitPrice;
	}

	/**
	 * ��������-���
	 */
	public double getOtherAmount() {
		return otherAmount;
	}

	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	
}
