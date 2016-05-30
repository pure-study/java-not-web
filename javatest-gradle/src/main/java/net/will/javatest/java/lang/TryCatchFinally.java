package net.will.javatest.java.lang;

public class TryCatchFinally {
    public static int increaseIt() {
        int retValue = 0;
        
        while (true) {
            try {
                retValue++;
                break;
            } finally {
                retValue++;  // it will be executed before 'break'
            }
        }
        
        return retValue;
    }
}
