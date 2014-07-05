/**
 * 
 */
package net.will.javatest.java.lang;

import java.nio.charset.Charset;

/**
 * @author Will
 *
 */
public class StringBasicTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		testLength();
		try {
			testLengthInAdvance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testLengthInAdvance() throws Exception {
        // The whole result of this test denpends entirely on which encoding
        // we use for this original string 's'. We may run this test with 2
        // different encodings to compile this java source file:
        //   - UTF-8
        //   - GBK
       System.out.println( Charset.defaultCharset().name() );
       System.out.println( "=============" );
       
       // However, no matter what encoding I use for this file, when I
       // decompile this class, I find that there is no difference on
       // the next line - it was always:
       //     String s = "\u4E2D\u6587";
       // Yet, it will have different output for "s.getBytes().length".
       String s = "中文";
       for (char ch : s.toCharArray() ) {
          System.out.println( Integer.toHexString(ch) );
       }
       System.out.println( "=============" );
       
       System.out.println( s );
       System.out.println( s.length() );
       System.out.println( s.getBytes().length );
       System.out.println( "UTF-8 " + s.getBytes("UTF-8").length );
       System.out.println( "UTF-16 " + s.getBytes("UTF-16").length );
       System.out.println( "UTF-32 " + s.getBytes("UTF-32").length );
       System.out.println( "GBK " + s.getBytes("GBK").length );
      
       System.out.println( "=============" );
      
       // Notice how this transcoding works.
       String t = new String(s.getBytes("GBK"), "GBK");
       // There might be gibberish this line if the default charset is not GBK:
       System.out.println( new String(s.getBytes("GBK")) );
       System.out.println( t );
       System.out.println( t.length() );
       System.out.println( t.getBytes().length );
       System.out.println( "UTF-8 " + t.getBytes("UTF-8").length );
       System.out.println( "UTF-16 " + t.getBytes("UTF-16").length );
       System.out.println( "UTF-32 " + t.getBytes("UTF-32").length );
       System.out.println( "GBK " + s.getBytes("GBK").length );
      
       System.out.println( "=============" );
      
       String r = new String(s.getBytes("UTF-16"), "UTF-16");
       System.out.println( r );
       System.out.println( r.length() );
       System.out.println( r.getBytes().length );
       System.out.println( "UTF-8 " + r.getBytes("UTF-8").length );
       System.out.println( "UTF-16 " + r.getBytes("UTF-16").length );
       System.out.println( "UTF-32 " + r.getBytes("UTF-32").length );
       System.out.println( "GBK " + s.getBytes("GBK").length );
      
       System.out.println( "=============" );
      
       String e = "ascii";
       System.out.println( e );
       System.out.println( e.length() );
       System.out.println( e.getBytes().length );
       System.out.println( "UTF-8 " + e.getBytes("UTF-8").length );
       System.out.println( "UTF-16 " + e.getBytes("UTF-16").length );
       System.out.println( "UTF-32 " + e.getBytes("UTF-32").length );
       System.out.println( "GBK " + e.getBytes("GBK").length );
	}
	
	public static void testLength() {
		String a1 = "123";
		String a2 = "中文";
		System.out.println(a1.length());
		System.out.println(a1.getBytes().length);
		System.out.println(a2.length());
		System.out.println(a2.getBytes().length);
	}

}
