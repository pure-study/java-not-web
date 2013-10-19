/**
 * 
 */
package net.will.minispring;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * 
 * @author Will
 * @version 2013-8-10
 */
public class BeanWrapperImpl implements BeanWrapper {
	private Object object;
	
	private static final Map<Class<?>, PropertyDescriptor[]> introspectionCache =
			Collections.synchronizedMap(new WeakHashMap<Class<?>, PropertyDescriptor[]>());
	
	public BeanWrapperImpl(Object object) {
		setWrappedInstance(object);
	}

	@Override
	public Object getPropertyValue(String propName) {
		if ( ! isReadableProperty(propName) ) {
			throw new NotReadablePropertyException(this.object.getClass(), propName);
		}
		try {
			PropertyDescriptor pd = getPropertyDescriptor(propName);
			Method rdMethod = pd.getReadMethod();
			
			Object value = rdMethod.invoke(this.object, (Object[]) null);
			return value;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setPropertyValue(String propName, Object value) {
		if ( ! isWritableProperty(propName) ) {
			throw new NotWritablePropertyException(this.object.getClass(), propName);
		}
		try {
			PropertyDescriptor pd = getPropertyDescriptor(propName);
			Object newValue = value;
			if ( pd.getPropertyType().isPrimitive() ) {
				if ( Integer.TYPE == pd.getPropertyType() ) {
					newValue = Integer.valueOf(value.toString());
				}
			}
			
			Method wtMethod = pd.getWriteMethod();
			wtMethod.invoke(this.object, newValue);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getWrappedInstance() {
		return this.object;
	}

	@Override
	public void setWrappedInstance(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Cannot set BeanWrapperImpl target to a null object");
		}
		this.object = object;
		loadIntrospectionForClass(object.getClass());
	}
	
	/**
	 * Load bean information into a cache, because this operation will be slow.
	 * 
	 * @param clazz
	 * @throws IntrospectionException 
	 */
	protected PropertyDescriptor[] loadIntrospectionForClass(Class<?> clazz) {
		if (null == clazz) {
			throw new IllegalArgumentException("No bean class specified");
		}
		
		PropertyDescriptor[] descriptors = null;
		descriptors = introspectionCache.get(clazz);
		if (descriptors != null) {
			return descriptors;
		}
		
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(clazz);
			
			descriptors = beanInfo.getPropertyDescriptors();
			if (null == descriptors) {
				descriptors = new PropertyDescriptor[0];
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
			descriptors = new PropertyDescriptor[0];
		}
		
		introspectionCache.put(clazz, descriptors);
		return descriptors;
	}
	
	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		Class<?> clazz = object.getClass();
		PropertyDescriptor[] pds = introspectionCache.get(clazz);
		if (null == pds) {
			pds = loadIntrospectionForClass(clazz);
		}
		return pds;
	}

	@Override
	public PropertyDescriptor getPropertyDescriptor(String propName) {
		PropertyDescriptor[] pds = getPropertyDescriptors();
		for (PropertyDescriptor pd : pds) {
			if (pd.getName().equals(propName)) {
				return pd;
			}
		}
		return null;  // shouldn't be here
	}

	@Override
	public Class<?> getPropertyType(String propName) {
		PropertyDescriptor pd = getPropertyDescriptor(propName);
		return pd.getPropertyType();
	}

	@Override
	public boolean isReadableProperty(String propName) {
		if (null == propName) {
			throw new IllegalArgumentException("Can't find readability status for null property");
		}
		PropertyDescriptor pd = getPropertyDescriptor(propName);
		if (pd != null && pd.getReadMethod() != null) { // && pd.getReadMethod().isAccessible()
			return true;
		}
		
		return false;
	}

	@Override
	public boolean isWritableProperty(String propName) {
		if (null == propName) {
			throw new IllegalArgumentException("Can't find writability status for null property");
		}
		PropertyDescriptor pd = getPropertyDescriptor(propName);
		if (pd != null && pd.getWriteMethod() != null) { // && pd.getWriteMethod().isAccessible()
			return true;
		}
		return false;
	}

}
