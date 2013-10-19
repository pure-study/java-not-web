/**
 * 
 */
package com.will.aet.models;

import java.util.ArrayList;
import java.util.List;

import com.will.aet.common.model.BaseModel;

/**
 * @author Will
 * @version 2010-7-11
 *
 */
public abstract class InvoiceItem extends BaseModel {
	private List<InvoiceSubItem> invoiceSubItems;

	public List<InvoiceSubItem> getInvoiceSubItems() {
		if (null == invoiceSubItems) {
			invoiceSubItems = new ArrayList<InvoiceSubItem>();
		}
		return invoiceSubItems;
	}

	public void setInvoiceSubItems(List<InvoiceSubItem> invoiceSubItems) {
		this.invoiceSubItems = invoiceSubItems;
	}
}
