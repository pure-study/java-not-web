/**
 * 
 */
package net.will.dpij.interfacedps.compositedp;

import java.util.Iterator;
import java.util.List;

/**
 * @author Will
 *
 */
public class MachineComposite extends MachineComponent {
	private List<MachineComponent> components;

	public List<MachineComponent> getComponents() {
		return components;
	}

	public void setComponents(List<MachineComponent> components) {
		this.components = components;
	}

	/* (non-Javadoc)
	 * @see net.will.dpij.compositedp.MachineComponent#getMachineCount()
	 */
	@Override
	public int getMachineCount() {
		int sum = 0;
		
		for (Iterator<MachineComponent> iter = components.iterator(); iter.hasNext();) {
			MachineComponent obj = iter.next();
			sum += obj.getMachineCount();
		}
		
		return sum;
	}

}
