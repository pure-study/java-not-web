/**
 * 
 */
package net.will.minispring;

import java.beans.PropertyDescriptor;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public interface BeanWrapper {
	Object getPropertyValue(String propName);
	
	void setPropertyValue(String propName, Object value);
	
	Object getWrappedInstance();
	
	void setWrappedInstance(Object object);
	
	PropertyDescriptor[] getPropertyDescriptors();
	
	PropertyDescriptor getPropertyDescriptor(String propName);
	
	Class<?> getPropertyType(String propName);
	
	boolean isReadableProperty(String propName);
	
	boolean isWritableProperty(String propName);
}
