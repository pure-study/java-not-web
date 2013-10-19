/**
 * 
 */
package net.will.minispring;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public interface BeanDefinitionRegistry {
	public void registerBeanDefinition(String beanName, BeanDefinition bd);
}
