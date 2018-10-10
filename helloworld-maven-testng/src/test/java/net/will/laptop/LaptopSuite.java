package net.will.laptop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopSuite {
    @Test(groups={ "simple" })
    public void testCaseLA() {
        System.out.println("running Laptop - testCaseA");
        Assert.assertTrue(true);
    }

    @Test(groups={ "simple", "complex" })
    public void testCaseLB() {
        System.out.println("running Laptop - testCaseB");
        Assert.assertTrue(true);
    }

    @Test(groups={ "complex" })
    public void testCaseLC() {
        System.out.println("running Laptop - testCaseC");
        Assert.assertTrue(true);
    }
    
    @Test(groups={ "functionality" })
    public void testPowerOn() {
        Laptop laptop = new Laptop();
        laptop.powerOn();
        
        Assert.assertTrue(laptop.isRunning());
    }
}
