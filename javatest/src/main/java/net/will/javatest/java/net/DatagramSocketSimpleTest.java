/**
 * @(#)DatagramSocket.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <p>基于UDP的Socket编程：</p>
 * 
 * <p>
 * 接收端程序编写：
 * 1. 调用DatagramSocket(int port)创建一个数据报套接字，并绑定到指定端口上；
 * 2. 调用DatagramPacket(byte buf[], int length)，建立一个字节数组以接收UDP包；
 * 3. 调用DatagramPacket类的receiver()，接收UDP包；
 * 4. 最后关闭数据报套接字。
 * </p>
 * <p>
 * 发送端程序编写：
 * 1. 调用DatagramSocket()创建一个数据报套接字；
 * 2. 调用DatagramPacket(byte buf[], int length, InetAddress address, int port)，建立要发送的UDP包；
 * 3. 调用DatagramSocket类的send()，发送UDP包；
 * 4. 最后关闭数据报套接字。
 * </p>
 * <p>
 * 用DatagramSocket只允许数据报发送一个目的地址，java.net包中提供了一个类MulticastSocket，允许
 * 数据报以广播方式发送到该端口的所有客户。MulticastSocket用在客户端，监听服务器广播来的数据。
 * </p>
 *
 * @author Will
 * @version 2012-4-10
 */
public class DatagramSocketSimpleTest {

	public static void main(String[] args) {
		if (args.length > 0) {
			receive();
		} else {
			send();
		}
	}
	
	public static void send() {
		try {
			DatagramSocket ds = new DatagramSocket();
			String str = "Hello, this is Will";
			DatagramPacket dp = new DatagramPacket(str.getBytes(),
					str.length(), InetAddress.getByName("localhost"), 5000);
			ds.send(dp);
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void receive() {
		try {
			DatagramSocket ds = new DatagramSocket(5000);
			byte[] buf = new byte[128];
			DatagramPacket dp = new DatagramPacket(buf, 128);
			ds.receive(dp);
			System.out.println(new String(buf, 0, dp.getLength()));
			ds.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
