package net.will.mobile;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileSuite {
    @Test(groups={ "simple" })
    public void testCaseMA() {
        System.out.println("running Mobile - testCaseA");
        Assert.assertTrue(true);
    }

    @Test(groups={ "simple", "complex" })
    public void testCaseMB() {
        System.out.println("running Mobile - testCaseB");
        Assert.assertTrue(true);
    }

    @Test(groups={ "complex" })
    public void testCaseMC() {
        System.out.println("running Mobile - testCaseC");
        Assert.assertTrue(true);
    }
}
