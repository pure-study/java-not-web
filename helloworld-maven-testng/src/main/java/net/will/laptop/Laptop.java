package net.will.laptop;

public class Laptop {
    private boolean running = false;
    
    public Laptop() {
    }
    
    public void powerOn() {
        running = true;
    }
    
    public void powerOff() {
        running = false;
    }
    
    public boolean isRunning() {
        return running;
    }
    
}
