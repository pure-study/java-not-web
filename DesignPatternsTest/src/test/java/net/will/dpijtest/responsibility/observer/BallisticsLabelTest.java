package net.will.dpijtest.responsibility.observer;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import net.will.dpij.responsibility.observer.BallisticsLabel;
import net.will.dpij.responsibility.observer.Tpeak;

public class BallisticsLabelTest {

	@SuppressWarnings("unused")
	@Test
	public void testBallisticsLabel() {
		Tpeak tpeak = new Tpeak();
		BallisticsLabel testor = new BallisticsLabel(tpeak);
	}

	@Ignore("Not Ready")
	@Test
	public void testUpdateObservableObject() {
		fail("Not yet implemented");
	}

}
