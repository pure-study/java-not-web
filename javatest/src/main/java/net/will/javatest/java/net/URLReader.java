/**
 * @(#)URLReader.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * A test for java.net.URL.
 *
 * @author Will
 * @version 2012-4-10
 */
public class URLReader {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.baidu.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String inputLine;
		while ( (inputLine = in.readLine()) != null ) {
			System.out.println(inputLine);
		}
		in.close();
	}

}
