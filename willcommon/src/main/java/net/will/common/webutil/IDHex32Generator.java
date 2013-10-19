/**
 * 
 */
package net.will.common.webutil;

import java.util.Properties;

import org.hibernate.id.UUIDHexGenerator;
import org.hibernate.type.StandardBasicTypes;

/**
 * @author Will
 * @version 2011-10-10
 */
public class IDHex32Generator {
	/**
	 * Try to synchronize here, though it will be synchronized in AbstractUUIDGenerator.getCount().
	 * 
	 * @return
	 * @throws Exception
	 */
	public synchronized String generateNextStrId() throws Exception {
		return (String) uuidHexGenerator.generate(null, null);
	}
	
	public synchronized static IDHex32Generator getInstance() {
		if (null == singleton) {
			singleton = new IDHex32Generator();
		}
		return singleton;
	}
	
	/**
	 * Proxy for org.hibernate.id.UUIDHexGenerator.
	 */
	private UUIDHexGenerator uuidHexGenerator;
	
	private static IDHex32Generator singleton;
	
	private IDHex32Generator() {
		uuidHexGenerator = new UUIDHexGenerator();
		Properties props = new Properties();
		props.setProperty("separator", "");
		uuidHexGenerator.configure(StandardBasicTypes.STRING, props, null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IDHex32Generator generator = IDHex32Generator.getInstance();
			System.out.println(generator.generateNextStrId()); // 8aa0810a32f1075c0132f10761f90000
			System.out.println(generator.generateNextStrId());
			System.out.println(generator.generateNextStrId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
