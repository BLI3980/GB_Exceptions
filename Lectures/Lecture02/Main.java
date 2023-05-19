package Lectures.Lecture02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // NullPointerException
//        String name = null;
//        System.out.println(name.length()); // NullPointerException: Cannot invoke "String.length()" because "name" is null

        // ClassCastException
//        Object object = new String("123");
//        File file = (File) object;
//        System.out.println(file); //ClassCastException: class java.lang.String cannot be cast to class java.io.File
        // (java.lang.String and java.io.File are in module java.base of loader 'bootstrap')

        // NumberFormatException
//        String number = "123fq";
//        int result = Integer.parseInt(number);
//        System.out.println(result); // NumberFormatException: For input string: "123fq"

        // UnsupportedOperationException
//        List<Object> emptyList = Collections.emptyList();
//        emptyList.add(new Object()); // UnsupportedOperationException

        // try-catch ==================================================
        int number = 1;
        try {
//            number = 10 / 0;
//            String test = null;
//            System.out.println("test length is: " + test.length());
            Collections.emptyList().add(new Object());
        } catch (ArithmeticException e) {
            System.out.println("Exception: Operation divide by zero not supported");
        } catch (NullPointerException e) {
            System.out.println("Exception: The object is null");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
//        System.out.println(number); // 1

        // finally ==================================================
        FileReader test = null;
        try {
            test = new FileReader("test");
            test.read();
        } catch (RuntimeException | IOException e) {
            System.out.println("Catch exception: " + e.getClass().getSimpleName());
        } finally { // finally will always work, regardless whether catch executed or not
            System.out.println("Finally start.");
            if (test != null) {
                try {
                    test.close();
                } catch (IOException e) {
                    System.out.println("Exception while close. ");
                }
            }
            System.out.println("Finally end.");
        }


    }
}
