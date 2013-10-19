/**
 * 
 */
package net.will.dpij.responsibility.mediator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * @author Will
 * @version 2008-11-19
 *
 */
public class TubMediator {
	protected Map<Tub, Machine> tubToMachine = new HashMap<Tub, Machine>();
	
	public Machine getMachine(Tub t) {
		// Challenge!
		return tubToMachine.get(t);
	}
	
	public Set<Tub> getTubs(Machine m) {
		Set<Tub> set = new HashSet<Tub>();
		Iterator<Entry<Tub, Machine>> i = tubToMachine.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry<Tub, Machine> entry = i.next();
			if (entry.getValue().equals(m)) {
				set.add(entry.getKey());
			}
		}
		
		return set;
	}
	
	public void set(Tub t, Machine m) {
		// Challenge!
		tubToMachine.put(t, m);
	}
}
