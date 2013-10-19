/**
 * 
 */
package net.will.minispring.cfgreaders;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.will.common.CommonUtil;
import net.will.minispring.BeanDefinition;
import net.will.minispring.BeanDefinitionRegistry;
import net.will.minispring.PropertyValue;
import net.will.minispring.RuntimeBeanReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Will
 * @version 2013-8-7
 */
public class XmlConfigReader implements ConfigReader {
	protected final Log logger = LogFactory.getLog(getClass());
	
	public static final String ELEMENT_BEAN = "bean";
	public static final String ELEMENT_PROPERTY = "property";
	
	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_CLASS = "class";
	public static final String ATTRIBUTE_SCOPE = "scope";
	
	public static final String ATTRIBUTE_NAME = "name";
	public static final String ATTRIBUTE_VALUE = "value";
	public static final String ATTRIBUTE_REF = "ref";
	
	private final BeanDefinitionRegistry registry;
	
	public XmlConfigReader(BeanDefinitionRegistry registry) {
		this.registry = registry;
	}

	@Override
	public void loadConfig(String configPath) {
		InputStream is = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = factory.newDocumentBuilder();
			is = new BufferedInputStream(new FileInputStream(configPath));
			Document doc = docBuilder.parse(is);
			Element root = doc.getDocumentElement();
			
			NodeList nl = root.getChildNodes();
			for (int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if (node instanceof Element) {
					Element ele = (Element) node;
					if (ELEMENT_BEAN.equals(node.getNodeName())) {
						BeanDefinition bd = new BeanDefinition();
						parseBeanAttributes(bd, ele);
						parsePropertyValues(bd, ele);
						
						String beanId = bd.getBeanName();
						registry.registerBeanDefinition(beanId, bd);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			CommonUtil.close(is);
		}
	}
	
	protected String parseBeanAttributes(BeanDefinition bd, Element beanEle) {
		String beanId = beanEle.getAttribute(ATTRIBUTE_ID);
		bd.setBeanName(beanId);
		
		if (beanEle.hasAttribute(ATTRIBUTE_CLASS)) {
			String className = beanEle.getAttribute(ATTRIBUTE_CLASS);
			bd.setBeanClassName(className);
		}
		
		if (beanEle.hasAttribute(ATTRIBUTE_SCOPE)) {
			String scope = beanEle.getAttribute(ATTRIBUTE_SCOPE);
			bd.setScope(scope);
		}
		
		return beanId;
	}
	
	protected void parsePropertyValues(BeanDefinition bd, Element beanEle) {
		NodeList propNodes = beanEle.getChildNodes();
		for (int i = 0; i < propNodes.getLength(); i++) {
			Node propNode = propNodes.item(i);
			if (propNode instanceof Element) {
				Element propEle = (Element) propNode;
				if (ELEMENT_PROPERTY.equals(propEle.getNodeName())) {
					String attrName = propEle.getAttribute(ATTRIBUTE_NAME);
					if (CommonUtil.isEmptyString(attrName)) {
						throw new ConfigReaderException(
								"Property name cannot be empty in Bean: " + bd.getBeanName());
					}
					
					PropertyValue pv = null;
					if (propEle.hasAttribute(ATTRIBUTE_VALUE)) {
						String attrValue = propEle.getAttribute(ATTRIBUTE_VALUE);
						pv = new PropertyValue(attrName, attrValue);
					} else if (propEle.hasAttribute(ATTRIBUTE_REF)) {
						String attrRef = propEle.getAttribute(ATTRIBUTE_REF);
						if (CommonUtil.isEmptyString(attrRef)) {
							throw new ConfigReaderException(
									"Property cannot reference to EMPTY in Bean: " + bd.getBeanName());
						}
						pv = new PropertyValue(attrName, new RuntimeBeanReference(attrRef));
					} else {
						throw new ConfigReaderException("No value for Property " + attrName +
								" in Bean: " + bd.getBeanName());
					}
					bd.addPropertyValue(pv);
				}
			}
		}
	}

}
