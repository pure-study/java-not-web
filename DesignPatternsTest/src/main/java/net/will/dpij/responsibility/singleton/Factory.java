package net.will.dpij.responsibility.singleton;

public class Factory {
	private static Factory factory;
	private static Object classLock = Factory.class;
	
	@SuppressWarnings("unused")
	private long wipMoves;
	
	private Factory() {
		this.wipMoves = 0;
	}
	
	public static Factory getFactory() {
		synchronized (classLock) {
			if (null == factory) {
				factory = new Factory();
			}
			
			return factory;
		}
	}
	
	public void recordWipMove() {
		synchronized (classLock) {
			this.wipMoves++;
		}
	}
}
