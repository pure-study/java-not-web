/**
 * @(#)Rocket.java - Will's practices.
 */
package net.will.dpij.responsibility.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Will
 * @version v1.0 2008-11-20
 */
public interface Rocket extends Remote {
	public void boost(double factor) throws RemoteException;
	
	public double getApogee() throws RemoteException;
	
	public double getPrice() throws RemoteException;
}
