/**
 * 
 */
package com.will.aet.models;

import com.will.aet.common.model.BaseModel;

/**
 * @author Will
 * @version 2010-7-11
 *
 */
public abstract class InvoiceSubItem extends BaseModel {
	private int serialId;
	private String serialCode;
	private String prodName;
	private String specification;
	private String unitCode;
	private double amount;
	
	private String remark;

	/**
	 * 备注
	 */
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 序号
	 */
	public int getSerialId() {
		return serialId;
	}
	
	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}
	
	/**
	 * 编码
	 */
	public String getSerialCode() {
		return serialCode;
	}
	
	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	/**
	 * 名称
	 */
	public String getProdName() {
		return prodName;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	/**
	 * 规格
	 */
	public String getSpecification() {
		return specification;
	}
	
	public void setSpecification(String specification) {
		this.specification = specification;
	}

	/**
	 * 单位
	 */
	public String getUnitCode() {
		return unitCode;
	}
	
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	/**
	 * 数量
	 */
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
