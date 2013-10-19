/**
 * @(#)URLConnectionTest.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>A test for URLConnection.</p>
 * 
 * <p>
 * URL(Uniform Resource Locator)，通用资源定位符。如
 * http://www.sun.com.cn/index.asp就是一个URL，指向万维网的一个具体资源。
 * URI(Uniform Resource Identifier)，通用资源标识符。
 * URI纯粹是个符号结构，用于指定构成Web资源的字符串的各个不同部分。URL是一种
 * 特殊类型的URI，它包含了用于查找某个资源的足够信息。其它的URI，例如：
 * mailto:xxx@xxx.com.cn则不属于定位符，因为它里面不存在根据该标识符来查找的任
 * 何数据。这种URI称为URN(通用资源名)。
 * </p>
 * 
 * <p>
 * 在Java库中，URI类不包含用于访问通用资源标识符设定的任何方法，它的惟一作用是
 * 进行分析。相反，URL类则可以打开到达资源的一个字符串。而URLConnection代表应
 * 用程序和URL之间的通信链接。此类的实例可用于读取和写入此URL引用的资源。
 * </p>
 *
 * @author Will
 * @version 2012-4-10
 */
public class URLConnectionTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://127.0.0.1:8080/cgi-bin/backwords");
			URLConnection con = url.openConnection();
			
			DataInputStream dis = new DataInputStream(con.getInputStream());
			PrintStream ps = new PrintStream(con.getOutputStream());
			
			String line = dis.readUTF();
			System.out.println(line);
			ps.println("client...");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
