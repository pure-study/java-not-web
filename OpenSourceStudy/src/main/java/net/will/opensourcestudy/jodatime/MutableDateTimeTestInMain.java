/**
 * @(#)MutableDateTimeTestInMain.java - Will's practices of Project OpenSourceStudy.
 */
package net.will.opensourcestudy.jodatime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.joda.time.MutableDateTime;

/**
 * 
 *
 * @author Will
 * @version v1.0, 2009-12-17
 *
 */
public class MutableDateTimeTestInMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MutableDateTime mdt1 = new MutableDateTime();
		MutableDateTime mdt2 = new MutableDateTime();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println("mdt1: " + df.format(mdt1.toDate()));
		System.out.println("mdt2: " + df.format(mdt2.toDate()));
		
//		System.out.println("mdt1.hourOfDay().roundFloor().toDate(): "
//				+ df.format(mdt1.hourOfDay().roundFloor().toDate()));
//		System.out.println("mdt2.hourOfDay().roundCeiling().toDate(): "
//				+ df.format(mdt2.hourOfDay().roundCeiling().toDate()));
		
		mdt1.setRounding(mdt1.hourOfDay().getField(), MutableDateTime.ROUND_FLOOR);
		mdt2.setRounding(mdt2.hourOfDay().getField(), MutableDateTime.ROUND_CEILING);
		System.out.println("mdt1: " + df.format(mdt1.toDate()));
		System.out.println("mdt2: " + df.format(mdt2.toDate()));
		
		System.out.println( mdt1.hourOfDay().get() );
		System.out.println( df.format(mdt1.toDate()) );
		System.out.println( df.format(mdt1.hourOfDay().add(1).toDate()) );
		
		System.out.println( df.format(mdt1.hourOfDay().roundFloor().toDate()) );
		System.out.println( df.format(mdt1.hourOfDay().roundCeiling().toDate()) );
		
		// the last day of last month
		mdt1 = mdt1.monthOfYear().add(-1).monthOfYear().roundCeiling().dayOfMonth().add(-1);
//		System.out.println( df.format(mdt1.dayOfMonth().roundCeiling().toDate()) );
		System.out.println( df.format(mdt1.toDate()) );
		
		System.out.println("=========================================");
		MutableDateTime startTime = new MutableDateTime();
		startTime.setMonthOfYear(1);
		System.out.println( df.format(startTime.toDate()) );
		startTime.monthOfYear().roundFloor();
		System.out.println( df.format(startTime.toDate()) );
		
		MutableDateTime endTime = new MutableDateTime();
		endTime.setMonthOfYear(1);
		System.out.println( df.format(endTime.toDate()) );
		endTime.monthOfYear().roundCeiling().secondOfMinute().add(-1);
		System.out.println( df.format(endTime.toDate()) );
	}

}
