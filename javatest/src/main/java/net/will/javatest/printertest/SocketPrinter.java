package net.will.javatest.printertest;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * 
 * @author Will
 * @version 2010-07-01
 *
 */
public class SocketPrinter {
	private static Logger logger = Logger.getLogger(SocketPrinter.class.getName());
	
	public static void main(String[] args) {
		print2Net();
//		print2LPT1();
	}
	
	/**
	 * 通过socket无驱网络打印。
	 * 
	 */
	public static void print2Net() {
		String ipaddr = "192.168.123.100";
		int port = 9100;
		
		try {
			Socket client=new java.net.Socket();
			PrintWriter socketWriter;
			
			logger.info("Connect to Socket: " + ipaddr + ":" + port);
			client.connect(new InetSocketAddress(ipaddr, port),3000);
			logger.info("Connect to Socket success!");
			
			// 创建一个 socket
			socketWriter = new PrintWriter(client.getOutputStream());
			
			logger.info("Ready to write...");
			socketWriter.write(0x1B);   // 初始化打印机
			socketWriter.write(0x40);
			
			socketWriter.write(0x1B);   // 打印并走纸
			socketWriter.write(0x4A);
			socketWriter.write(0x05);
			
			socketWriter.write(0x0A);   // 换行
			socketWriter.println("巧富餐饮软件后厨单据"); 
			socketWriter.println("桌位 14 桌，人数 3"); 
			socketWriter.println("剁椒鱼头 1 份");
			logger.info("Write end");
			
			for (int i = 0; i < 5; i++) {
				socketWriter.println();  // 打印完毕自动走纸
			}
			
			socketWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * LPT1端口打印。
	 */
	public static void print2LPT1() {
		try {  
			FileWriter out = new FileWriter("lpt1");
			
			out.write(0x1B);  // 初始化POS
			out.write(0x40);
			
			out.write("       巧富餐饮软件后厨单据");
			out.write("桌位 14 桌，人数 3");
			out.write("剁椒鱼头 1 份");
			
			out.write(0x0A); // 通过输出换行走纸
			out.write(0x0A);
			out.write(0x0A);
			out.write(0x0A);
			out.write(0x0A);
			
			out.close();
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
	}
}
