/**
 * @(#)CastorTestWithMappingFile.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.castor.withmapping;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import net.will.opensourcestudy.common.CommonVariables;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.XMLContext;

/**
 * @author Will
 * @version 2011-12-10
 */
public class CastorTestWithMappingFile {
	static String mappingFileName = "src/main/java/net/will/opensourcestudy/castor/withmapping/mapping.xml";
	
	static String outputXmlFile = CommonVariables.TEMP_OUTPUT_PATH + "people.xml";
	
	static String encoding = "UTF-8";

	public static void main(String[] args) {
		try {
			Mapping mapping = new Mapping();
			mapping.loadMapping(mappingFileName);
			
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			Marshaller msWriter = context.createMarshaller();
			Marshaller msOut = context.createMarshaller();
			
			File file = new File(outputXmlFile);
			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), encoding));
			Writer out = new BufferedWriter(new OutputStreamWriter(
					System.out));
			msWriter.setWriter(writer);
			msOut.setWriter(out);
			msWriter.setEncoding(encoding);
			msOut.setEncoding(encoding);
			
			People people = generateData();
			msWriter.marshal(people);
			msOut.marshal(people);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static People generateData() {
		Person p1 = new Person("first", "last", "中文属性");
		Person p2 = new Person("first2", "last2", "中文属性2");
		
		People pp = new People();
		pp.setPerson(new Person[]{p1, p2});
		
		return pp;
	}

}
