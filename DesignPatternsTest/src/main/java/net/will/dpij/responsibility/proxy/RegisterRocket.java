/**
 * @(#)RegisterRocket.java - Will's practices.
 */
package net.will.dpij.responsibility.proxy;

import java.rmi.Naming;

/**
 * @author Will
 * @version v1.0 2008-11-20
 *
 */
public class RegisterRocket {
	public static void main(String[] args) {
		try {
			Rocket biggie = new RocketImpl(29.95, 820);
			Naming.rebind("rmi://127.0.0.1:5000/Biggie", biggie);
			System.out.println("Register success!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
