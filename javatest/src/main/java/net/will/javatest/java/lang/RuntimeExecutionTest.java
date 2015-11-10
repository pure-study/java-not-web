package net.will.javatest.java.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeExecutionTest {
    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec("df -k");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            process.waitFor();
            String line;
            while ( (line = reader.readLine()) != null ) {
                System.out.println(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
