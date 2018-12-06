package net.will.javatest.basicconcept.jdk7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    
    public String read1stLineOfFile(String filePath) throws FileNotFoundException, IOException {
        try ( FileReader fis = new FileReader(filePath);
              BufferedReader bufferedReader = new BufferedReader(fis) ) {
            return bufferedReader.readLine();
        }
    }
    
}
