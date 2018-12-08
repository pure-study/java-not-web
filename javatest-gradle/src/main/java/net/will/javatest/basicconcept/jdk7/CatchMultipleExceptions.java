package net.will.javatest.basicconcept.jdk7;

public class CatchMultipleExceptions {
    
    public static void main(String args[]) {
        int b = 0, x[] = { 10, 20, 30 };
        try {
            int c = x[3] / b;
            System.out.println(c);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    
}
