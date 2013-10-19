package net.will.dpij.responsibility.observer;

import java.util.Observable;

public class Tpeak extends Observable {
	private double value;
	
	public Tpeak() {
		super();
		value = 0.0;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
		this.setChanged();
		this.notifyObservers();
	}
}
