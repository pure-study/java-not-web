package net.will.dpijtest.responsibility.proxy;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.rmi.Naming;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import net.will.dpij.responsibility.proxy.Rocket;

public class RocketTest {
	private static Rocket biggie = null;
	
	@BeforeClass
	public static void runBeforeClass() {
		try {
			Object obj = Naming.lookup("rmi://127.0.0.1:5000/Biggie");
			biggie = (Rocket) obj;
		} catch (Exception e) {
			e.printStackTrace();
			fail("=====Initialize RMI Object failed!=====");
		}
	}

	@Test(timeout = 60000)
	public void testGetApogee() {
		try {
			assertEquals(new Double(820), new Double(biggie.getApogee()));
		} catch (RemoteException e) {
			e.printStackTrace();
			fail("Invoke getApogee() failed!");
		}
	}

	@Test(timeout = 60000)
	public void testGetPrice() {
		try {
			assertEquals(new Double(29.95), new Double(biggie.getPrice()));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Invoke getPrice() failed!");
		}
	}

}
