/**
 * @(#)ShowRocketClient.java - Will's practices.
 */
package net.will.dpij.responsibility.proxy;

import java.rmi.Naming;

/**
 * @author Will
 * @version v1.0 2008-11-20
 *
 */
public class ShowRocketClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Object obj = Naming.lookup("rmi://127.0.0.1:5000/Biggie");
			Rocket biggie = (Rocket) obj;
			System.out.println("Apogee is: " + biggie.getApogee());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
