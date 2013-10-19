/**
 * @(#)SimpleSocketTest.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>基于TCP的Socket编程方法：</p>
 * <p>
 * 服务器程序编写：
 * 1. 调用ServerSocket(int port)创建一个服务器端套接字，并绑定到指定端口上；
 * 2. 调用accept()，监听连接请求，如果客户端请求连接，则接受连接，返回通信套接字；
 * 3. 调用Socket类的getOutputStream()和getInputStream()获取输出流和输入流，开始网络数据的发送和接收；
 * 4. 最后关闭套接字。
 * </p>
 * <p>
 * 客户端程序编写：
 * 1. 调用Socket()创建一个套接字，并连接到服务器端；
 * 2. 调用Socket类的getOutputStream()和getInputStream()获取输出流和输入流，开始网络数据的发送和接收；
 * 3. 最后关闭套接字。
 * </p>
 *
 * @author Will
 * @version 2012-4-10
 */
public class SimpleSocketTest {

	public static void main(String[] args) {
		if (args.length > 0) {
			server();
		} else {
			client();
		}
	}
	
	public static void server() {
		try {
			ServerSocket ss = new ServerSocket(6000);
			Socket sc = ss.accept();
			OutputStream os = sc.getOutputStream();
			InputStream is = sc.getInputStream();
			
			os.write("Hello, welcome you.".getBytes());
			byte[] buf = new byte[128];
			int len = is.read(buf);
			System.out.println(new String(buf, 0, len));
			
			is.close();
			os.close();
			sc.close();
			ss.close();
		} catch (Exception e) {
		}
	}
	
	public static void client() {
		try {
			Socket sc = new Socket("localhost", 6000);
			OutputStream os = sc.getOutputStream();
			InputStream is = sc.getInputStream();
			
			os.write("Hello, welcome you.".getBytes());
			byte[] buf = new byte[128];
			int len = is.read(buf);
			System.out.println(new String(buf, 0, len));
			
			is.close();
			os.close();
			sc.close();
		} catch (Exception e) {
		}
	}

}
