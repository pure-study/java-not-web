/**
 * 
 */
package net.will.common.beans;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Will
 * @version 2011-9-28
 */
public class AbsBaseBeanTest {

	/**
	 * Test method for {@link net.will.common.beans.AbsBaseBean#toString()}.
	 */
	@Test
	public final void testToString() {
		AbsBaseBean obj = new AbsBaseBean() {
			private String myname;
			private String myaddr;

			{
				this.setMyname("name");
				this.setMyaddr("addr");
			}

			@SuppressWarnings("unused")
			public String getMyname() {
				return myname;
			}
			public void setMyname(String myname) {
				this.myname = myname;
			}
			@SuppressWarnings("unused")
			public String getMyaddr() {
				return myaddr;
			}
			public void setMyaddr(String myaddr) {
				this.myaddr = myaddr;
			}
		};
		
		AbsBaseBean obj2 = new AbsBaseBean() {
			@SuppressWarnings("unused")
			private String writeonly;
			
			{this.setWriteonly("writeonly");}
			
			public void setWriteonly(String writeonly) {
				this.writeonly = writeonly;
			}
		};
		
		AbsBaseBean obj3 = new AbsBaseBean() {
			private String readyonly;
			
			{this.readyonly = "readyonly";}

			@SuppressWarnings("unused")
			public String getReadyonly() {
				return readyonly;
			}
		};
		
		AbsBaseBean obj4 = new AbsBaseBean() {
			@SuppressWarnings("unused")
			private String onno;
			
			{this.onno = "onno";}
		};
		
		System.out.println(obj.toString());
		System.out.println(obj2.toString());
		System.out.println(obj3.toString());
		System.out.println(obj4.toString());
		assertTrue(true);
	}

}
