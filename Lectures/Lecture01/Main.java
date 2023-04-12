package Lectures.Lecture01;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Before error handling - 0; after - -1
        System.out.println((getFileSize(new File("123"))));
        // Before: Exception in thread "main" java.lang.ArithmeticException: / by zero
        // After: -1. However, not clear if result is correct or not
        // With custom exception handling: Divide by zero not acceptable.
        System.out.println(divide(-10, 0));


    }

//    public static long getFileSize(File file) {
//        return file.length();
//    }

    public static long getFileSize(File file) {
        if(!file.exists()) {
            return -1;
        }
        return file.length();
    }

    public static int divide(int a1, int a2) {
//        if(a2 == 0) {
//            return -1;
//        }
        if(a2 == 0) {
            throw new RuntimeException("Divide by zero not acceptable.");
        }
        return a1 / a2;
    }
}
