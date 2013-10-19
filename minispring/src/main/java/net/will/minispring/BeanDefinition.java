/**
 * 
 */
package net.will.minispring;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public class BeanDefinition {
	public static final String VALUE_SCOPE_SINGLETON = "singleton";
	public static final String VALUE_SCOPE_PROTOTYPE = "prototype";
	
	private Set<PropertyValue> props = new HashSet<PropertyValue>();
	
	private String beanName;
	
	private String beanClassName;
	
	private String scope = VALUE_SCOPE_SINGLETON;  // default for SINGLETON
	
	public void addPropertyValue(PropertyValue pv) {
		props.add(pv);
	}
	
	public Set<PropertyValue> getProps() {
		return this.props;
	}

	public boolean isPrototype() {
		return VALUE_SCOPE_PROTOTYPE.equals(scope);
	}
	
	public boolean isSingleton() {
		return VALUE_SCOPE_SINGLETON.equals(scope);
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
