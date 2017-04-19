package net.will.javatest.org.xml.sax;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class InputSourceTestMain {
    public static void main(String[] args) throws Exception {
        String xml = "<QueryResult >Asset</QueryResult>";
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml.trim()));
        Document doc = builder.parse(is);
        
        System.out.println(doc);
        Element elm = doc.getDocumentElement();
        System.out.println(elm.getTagName());
        System.out.println(elm.getTextContent());
    }
}
