package Lectures.Lecture03;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // try-with-resources ==================================================
        try (FileReader reader = new FileReader("test.txt");
             FileWriter writer = new FileWriter("test1.txt")) {
            while(reader.ready()){
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("Catch exception: " + e.getClass().getSimpleName());
        }
        System.out.println("Copy successful");
    }
}
