/**
 * @(#)RocketImpl.java - Will's practices.
 */
package net.will.dpij.responsibility.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Will
 * @version v1.0 2008-11-20
 *
 */
public class RocketImpl extends UnicastRemoteObject implements Rocket {
	private static final long serialVersionUID = -9096973128987892589L;
	
	protected double price;
	protected double apogee;
	
	public RocketImpl(double price, double apogee) throws RemoteException {
		this.price = price;
		this.apogee = apogee;
	}

	/**
	 * @see net.will.dpij.responsibility.proxy.Rocket#boost(double)
	 */
	@Override
	public void boost(double factor) {
		apogee *= factor;
	}

	/**
	 * @see net.will.dpij.responsibility.proxy.Rocket#getApogee()
	 */
	@Override
	public double getApogee() {
		return this.apogee;
	}

	/**
	 * @see net.will.dpij.responsibility.proxy.Rocket#getPrice()
	 */
	@Override
	public double getPrice() {
		return this.price;
	}

}
