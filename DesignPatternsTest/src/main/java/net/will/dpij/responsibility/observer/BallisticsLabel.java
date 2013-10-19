package net.will.dpij.responsibility.observer;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import net.will.dpij.common.util.NumberFormatHelper;

public class BallisticsLabel extends JLabel implements Observer {
	private static final long serialVersionUID = -6288762832227408508L;

	public BallisticsLabel(Tpeak tPeak) {
//		super();   // Java will call it automatically
		tPeak.addObserver(this); // register Observer
	}

	@Override
	public void update(Observable o, Object arg) {
		Tpeak tPeak = (Tpeak) o;
		double value = tPeak.getValue();
		
		this.setText( NumberFormatHelper.formatDouble(value) );
		repaint();
	}

}
