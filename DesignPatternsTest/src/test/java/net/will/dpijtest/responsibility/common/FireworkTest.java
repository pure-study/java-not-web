package net.will.dpijtest.responsibility.common;

import org.junit.Test;

import net.will.dpij.responsibility.common.Firework;

public class FireworkTest {

	@Test(expected = Exception.class)
	public void testCompare() {
//		fail("Not yet implemented");
		Firework f1 = new Firework(1.5);
		Firework f2 = new Firework(2.0);
		
		f1.compare(f2);
	}

}
