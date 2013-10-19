/**
 * 
 */
package com.will.aet.common.model;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author Will
 * @version 2010-7-9
 *
 */
public abstract class BaseModel {

	public String toString() {
		StringBuffer strToReturn = new StringBuffer();
		strToReturn.append(System.getProperty("line.separator") + "=========");
		strToReturn.append(this.getClass().getName());
		strToReturn.append(" BEGIN=========" + System.getProperty("line.separator"));

		PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(this);

		for (int i = 0; i < propDescs.length; i++) {
			String propName = propDescs[i].getName();
			if ("class".equals(propName)) {
				continue;
			}

			if (PropertyUtils.isReadable(this, propName)
					/*&& PropertyUtils.isWriteable(this, propName)*/) {
				strToReturn.append(System.getProperty("line.separator")
						+ " ==> " + propName + ": ");
				try {
					Object value = PropertyUtils.getProperty(this, propName);
					strToReturn.append(value);
				} catch (Exception e) {
					strToReturn.append("");
				}
			}
		}

    	strToReturn.append( System.getProperty("line.separator") + "=========" );
    	strToReturn.append( this.getClass().getName() );
    	strToReturn.append( " END=========" + System.getProperty("line.separator") );
    	return strToReturn.toString();

	}
}
