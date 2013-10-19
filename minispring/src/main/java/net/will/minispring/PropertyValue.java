/**
 * 
 */
package net.will.minispring;

import java.io.Serializable;

import net.will.common.CommonUtil;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public class PropertyValue implements Serializable {
	private static final long serialVersionUID = 5035722884263826236L;

	private final String name;
	
	private final Object value;
	
	public PropertyValue(String name, Object value) {
		if (CommonUtil.isEmptyString(name)) {
			throw new IllegalArgumentException("Property name cannot be null");
		}
		
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "PropertyValue: name='" + this.name + "', value=[" + this.value + "]";
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PropertyValue)) {
			return false;
		}
		PropertyValue otherPv = (PropertyValue) other;
		if (this.name.equals(otherPv.name) && ObjectUtils.equals(this.value, otherPv.value)) {
			return true;
		}
		return false;
	}
}
