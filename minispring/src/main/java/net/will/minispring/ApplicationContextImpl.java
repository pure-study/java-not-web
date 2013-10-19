/**
 * 
 */
package net.will.minispring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.will.minispring.cfgreaders.ConfigReader;
import net.will.minispring.cfgreaders.XmlConfigReader;

/**
 * 
 * @author Will
 * @version 2013-8-6
 */
public class ApplicationContextImpl implements ApplicationContext, BeanDefinitionRegistry {
	private final Map<String, Object> singletonCache = Collections
			.synchronizedMap(new HashMap<String, Object>());
	
	private final Map<String, BeanDefinition> beanDefinitions = Collections
			.synchronizedMap(new HashMap<String, BeanDefinition>());
	
	private final ConfigReader reader = new XmlConfigReader(this);
	
	public ApplicationContextImpl(String contextFilePath) {
		// load configs into beanDefinitions
		reader.loadConfig(contextFilePath);
	}
	
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition bd) {
		beanDefinitions.put(beanName, bd);
	}

	/* (non-Javadoc)
	 * @see net.will.minispring.ApplicationContext#getBean(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getBean(String name) {
		BeanDefinition bd = beanDefinitions.get(name);
		if (null == bd) {
			throw new NoSuchBeanDefinitionException("No definition for bean with name: " + name);
		}
		
		Object bean = null;
		if (bd.isSingleton()) {
			Object sharedInstance = singletonCache.get(name);
			if (null != sharedInstance) {
				return (T) sharedInstance;
			}
			
			bean = createBean(bd);
			singletonCache.put(name, bean);
		} else {
			bean = createBean(bd);
		}
		
		return (T) bean;
	}
	
	protected Object createBean(BeanDefinition bd) {
		Object bean = null;
		
		try {
			Object beanInstance = Class.forName(bd.getBeanClassName()).newInstance();
			BeanWrapper beanWrapper = new BeanWrapperImpl(beanInstance);
			
			Set<PropertyValue> pvs = bd.getProps();
			for (PropertyValue pv : pvs) {
				Object value = resolveValueIfNecessary(pv.getValue());
				beanWrapper.setPropertyValue(pv.getName(), value);
			}
			
			bean = beanWrapper.getWrappedInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	private Object resolveValueIfNecessary(Object value) {
		if (value instanceof RuntimeBeanReference) {
			RuntimeBeanReference ref = (RuntimeBeanReference) value;
			return getBean(ref.getRefName());
		}
		return value;
	}

}
