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
public class SimpleInvcSubItem extends InvoiceSubItem {
	private double unitPrice;
	
	private double moneyAmount;

	/**
	 * ����
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * ����
	 */
	public double getMoneyAmount() {
		return moneyAmount;
	}

	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	
}
