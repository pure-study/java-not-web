package net.will.dpij.responsibility.common;

public class Firework {
	public Firework(double weight) {
		this.weight = weight;
	}
	
	private double weight = 0.0;
	
	public double compare(Firework f) {
		return this.weight - f.weight;
	}
}
