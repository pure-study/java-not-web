/**
 * 
 */
package net.will.dpij.responsibility.observer;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Will
 * @version 2008-11-13
 * 
 */
public class ShowBallistics {
	private Tpeak tPeak;
	private JSlider slider;
	private double sliderMax;
	private double sliderMin;
	
	public ShowBallistics() {
		tPeak = new Tpeak();
	}
	
	public JSlider slider() {
		if (null == this.slider) {
			this.slider = new JSlider();
			sliderMax = slider.getMaximum();
			sliderMin = slider.getMinimum();
			
			slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					if (sliderMax == sliderMin) {
						return;
					}
					
					tPeak.setValue((slider.getValue() - sliderMin) / (sliderMax - sliderMin));
				}
			});
			
			slider.setValue(slider.getMinimum());
		}
		
		return this.slider;
	}
}
