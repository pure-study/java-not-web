/**
 * 
 */
package net.will.minispring;

import net.will.common.CommonUtil;

/**
 * 
 * @author Will
 * @version 2013-8-10
 */
public class RuntimeBeanReference {
	private final String refName;
	
	public RuntimeBeanReference(String refName) {
		if (CommonUtil.isEmptyString(refName)) {
			throw new IllegalArgumentException();
		}
		this.refName = refName;
	}

	public String getRefName() {
		return refName;
	}
	
	@Override
	public String toString() {
		return '<' + getRefName() + '>';
	}
}
