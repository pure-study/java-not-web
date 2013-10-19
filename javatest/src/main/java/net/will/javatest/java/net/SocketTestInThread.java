/**
 * @(#)SocketTestInThread.java - Will's practices of Project javatest.
 */
package net.will.javatest.java.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 参见SimpleSocketTest的说明。
 *
 * @author Will
 * @version 2012-4-10
 */
public class SocketTestInThread extends Thread {
	private Socket sc;
	public SocketTestInThread(Socket sc) {
		this.sc = sc;
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			server();
		} else {
			client();
		}
	}
	
	@Override
	public void run() {
		try {
			OutputStream os = sc.getOutputStream();
			InputStream is = sc.getInputStream();
			
			os.write("Hello, welcome you.".getBytes());
			byte[] buf = new byte[128];
			int len = is.read(buf);
			System.out.println(new String(buf, 0, len));
		} catch (Exception e) {
		}
	}
	
	public static void server() {
		try {
			ServerSocket ss = new ServerSocket(6000);
			while (true) {
				Socket sc = ss.accept();
				new SocketTestInThread(sc).start();
			}
		} catch (Exception e) {
		}
	}
	
	public static void client() {
		try {
			Socket sc = new Socket("localhost",6000);
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
