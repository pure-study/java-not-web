package net.will.javatest.java.regex;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
//    	testRegExp4FilePath();
//    	testFileDelete();
//    	testRegExp2();
    	testRegEx3();
//    	testFileExists();
    	
//    	somethingelse();
    }
    
    public static void testRegExp4FilePath() {
    	 Pattern p = Pattern.compile("/content/data/[^/]*/[^/]*");
    	 
    	 String s1 = "/content/uploaded/indemand.com";
    	 String s2 = "/content/data/indemand.com/2013-07-24";
    	 String s3 = "/content/data/indemand.com/2013-07-24/1374635563538";
    	 String s4 = "/content/data/WARNER";
    	 
    	 System.out.println(p.matcher(s1).matches());
    	 System.out.println(p.matcher(s2).matches());
    	 System.out.println(p.matcher(s3).matches());
    	 System.out.println(p.matcher(s4).matches());
    	 
    	 Matcher matcher = p.matcher(s3);
    	 System.out.println(matcher.find());
    	 System.out.println(matcher.start());
    }
    
    public static void testFileDelete() throws Exception {
    	File dir = new File("D:\\content\\data\\indemand.com\\2014-03-02\\1393813566484\\CLAA1212121212121208");
    	FileUtils.deleteDirectory(dir);
    	System.out.println(dir.getAbsolutePath());
    	System.out.println(dir.getParentFile().getParentFile().getAbsolutePath());
    }
    
    public static void testRegExp() {
    	String s = "H:\\Workspace_cms-oob-src\\cms-oob-src\\content-management-additional-device\\target\\test-classes\\test_dir\\abc\\1393844192900\\ASSET_ID\\movieAssert.mpg";
//    	String reg = "H:\\Workspace_cms-oob-src\\cms-oob-src\\content-management-additional-device\\target\\test-classes\\test_dir";
    	String reg = "H:\\\\Workspace_cms-oob-src";
    	System.out.println(reg);
    	System.out.println(s);
    	Matcher m = Pattern.compile(reg).matcher(s);
    	System.out.println(m.find());
    }
    
    public static void testRegExp2() {
    	String s = "H:\\Workspace_cms-oob-src\\cms-oob-src\\content-management-additional-device\\target\\test-classes\\test_dir\\Specified_directory1";
    	String s2 = "H:\\Workspace_cms-oob-src\\cms-oob-src\\content-management-additional-device\\target\\test-classes\\test_dir\\Specified_directory";
    	String reg = "H:\\\\Workspace_cms-oob-src\\\\cms-oob-src\\\\content-management-additional-device\\\\target\\\\test-classes\\\\test_dir\\\\Specified_directory";
    	
    	Pattern p = Pattern.compile(reg);
    	Matcher m1 = p.matcher(s);
    	Matcher m2 = p.matcher(s2);
    	System.out.println(m1.find(0));
    	System.out.println(m1.end());
    	System.out.println(s.length());
    	System.out.println("=================");
    	System.out.println(m2.find(0));
    	System.out.println(m2.end());
    	System.out.println(s2.length());
    }
    
    public static void testRegEx3() {
    	File file = new File(App.class.getResource("/").getFile());
    	String initPath = file.getAbsolutePath();
    	
    	System.out.println(initPath);
    	System.out.println( Matcher.quoteReplacement(initPath) );
    	System.out.println("=================");
    	
    	File file2 = new File(App.class.getResource(".").getFile());
    	String file2Path = file2.getAbsolutePath();
    	System.out.println(file2Path);
    	
    	String reg = initPath + File.separator + "[^" + File.separator + "]*";
    	System.out.println(reg);
    	Pattern p = Pattern.compile(Matcher.quoteReplacement(File.separator));
    	Matcher m = p.matcher(reg);
    	String newReg = m.replaceAll(Matcher.quoteReplacement(Matcher.quoteReplacement(File.separator)));
    	System.out.println( newReg );
    	System.out.println("=================");
    	
    	Pattern p2 = Pattern.compile(newReg);
    	Matcher m2 = p2.matcher(file2Path);
    	if (m2.find()) {
    		System.out.println("true");
    		System.out.println(m2.start());
    		System.out.println(m2.end());
    		System.out.println(file2Path.length());
    	} else {
    		System.out.println("false");
    	}
    	System.out.println("=================");
    	
    	System.out.println(p2.matcher("D:\\Workspace\\jdkinspection\\target\\classes\\net").matches());
    	System.out.println(p2.matcher("D:\\Workspace\\jdkinspection\\target\\classes\\net\\").matches());
    }
    
    public static void testFileExists() {
    	String s = "H:\\Workspace_cms-oob-src\\cms-oob-src\\content-management-additional-device\\target\\test-classes\\test_dir\\Specified_directory1\\abc";
    	File dir = new File(s);
    	System.out.println(dir.exists());
    	System.out.println(dir.getParentFile().exists());
    	System.out.println(dir.getParentFile().getPath());
    	System.out.println(dir.getParentFile().listFiles());
    	System.out.println("=================");
    	System.out.println(Pattern.quote(File.separator));
    }
    
    public static void somethingelse() {
    	System.out.println(System.getProperties());
    	System.out.println(System.getProperty("line.separator"));
    	System.out.println(System.getProperty("os.name"));
    }
}
