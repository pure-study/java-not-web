/**
 * 
 */
package net.will.minispring;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public class PropertyValueTest {

	@Test
	public void testHashCode() {
		PropertyValue pv = new PropertyValue("table", "user");
		int hc01 = pv.hashCode();
		System.out.println("pv.hashCode(): " + hc01);
		assertTrue(pv != null);
		
		Class<?> clazz = pv.getClass();
		Field[] fields = clazz.getDeclaredFields();
		assertTrue(fields != null);
		
		assertTrue(3 == fields.length);
		for (int i = 0; i < fields.length; i++) {
			Field fd = fields[i];
			System.out.println(fd.getName());
		}
		
		int hc02 = HashCodeBuilder.reflectionHashCode(pv);
		int hc03 = HashCodeBuilder.reflectionHashCode(pv, "serialVersionUID");
		assertTrue(hc02 == hc03);
	}

}
