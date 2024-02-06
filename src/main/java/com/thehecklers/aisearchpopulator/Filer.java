package com.thehecklers.aisearchpopulator;

import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Component
public class Filer {
    public void writeToFile(String filename, Iterable<Aircraft> aircraft) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Aircraft a : aircraft) {
                writer.println(a.toString());
            }
            System.out.println("File " + filename + " written");
        } catch (FileNotFoundException e) {
            System.err.println("Unable to open file " + filename);
            e.printStackTrace();
        }
    }
}
