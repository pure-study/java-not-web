/**
 * @(#)XMLOpUseCastor.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.castor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.castor.xml.XMLProperties;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;

/**
 * @author Will
 * @version 2011-11-25
 *
 */
public class XMLOpUseCastor {
	static String filename = "src/main/java/net/will/opensourcestudy/castor/people.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testWrite();
//		testRead();
//		testRead2();
	}
	
	static void testRead() {
		try {
			File file = new File(filename);
			Reader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			
			// 1.
			Unmarshaller un = new Unmarshaller(People.class);
			un.setValidation(false);
			People p = (People) un.unmarshal(reader);
			System.out.println(p);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testRead2() {
		try {
			File file = new File(filename);
			Reader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "UTF-8"));
			
			// 2.
			XMLContext context = new XMLContext();
			Unmarshaller u = context.createUnmarshaller();
			People p2 = (People) u.unmarshal(reader);
			System.out.println(p2);
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void testWrite() {
		try {
			File file = new File(filename);
			Writer writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			Writer out = new BufferedWriter(new OutputStreamWriter(
					System.out));
			
			Person[] ps = new Person[] {
					new Person("Dr. White", "Honey", "otherProp"),
					new Person("Gonzo", "Great", "otherProp"),
					new Person("三", "张", "otherProp"),       
					new Person("Phillip J.", "Fry", "otherProp")};
			People p = new People();
			p.setPerson(ps);
			
			// 1.
			Marshaller.marshal(p, out);
			System.out.println();
			// 2.
			Marshaller ms = new Marshaller(out);
			ms.setEncoding("UTF-8");
			ms.marshal(p);
			// 3.
			XMLContext context = new XMLContext();
			// 个性化的设置可以通过如下语句进行设置，或者在classpath根目录下
			// 建立castor.properties文件，并在其中进行设置。
			// 再或者，也可以自定义这个配置文件的位置。具体方式可以参见
			// org.castor.core.util.AbstractProperties.loadUserProperties(String)方法中的逻辑
			context.setProperty(XMLProperties.USE_INDENTATION, true);
			Marshaller m = context.createMarshaller();
			m.setWriter(writer);
			m.marshal(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
