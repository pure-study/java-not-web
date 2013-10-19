/**
 * 
 */
package net.will.common.webutil;

import org.hibernate.id.UUIDGenerator;

/**
 * @author Will
 * @version 2011-10-10
 */
public class IDGenerator {
	public synchronized String generateNextStrId() throws Exception {
		return (String) uuidGenerator.generate(null, null);
	}
	
	public synchronized static IDGenerator getInstance() {
		if (null == singleton) {
			singleton = new IDGenerator();
		}
		return singleton;
	}
	
	/**
	 * Proxy for org.hibernate.id.UUIDGenerator.
	 */
	private UUIDGenerator uuidGenerator;
	
	private static IDGenerator singleton;
	
	private IDGenerator() {
		uuidGenerator = UUIDGenerator.buildSessionFactoryUniqueIdentifierGenerator();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IDGenerator generator = IDGenerator.getInstance();
			System.out.println(generator.generateNextStrId());
			System.out.println(generator.generateNextStrId());
			String id = generator.generateNextStrId();
			System.out.println(id + ": " + id.length()); // cb018e28-1c04-46da-8a74-7990cf9203bd: 36
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
