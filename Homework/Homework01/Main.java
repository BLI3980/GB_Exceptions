package Homework.Homework01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* =================================================================================
        Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
         */
        // 1.
        System.out.println(divide(5, 0)); // ArithmeticException: / by zero

        // 2.
        int[] array = new int[5];
        System.out.println(array[10]); // ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5

        // 3.
        System.out.println(compareNumbers()); // InputMismatchException - if input is not an integer:


        /* =================================================================================
        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        и возвращающий новый массив, каждый элемент которого равен разности элементов
        двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
        как-то оповестить пользователя.
         */

        int[] array1 = new int[]{1, 4, -5, 8, -3, 0};
        int[] array2 = new int[]{7, 2, 0, -6, -9};
        int[] array3 = new int[]{2, 5, 9, -3, 1, 4};

        System.out.println(Arrays.toString(subtractArrays(array1, array2)));
        System.out.println(Arrays.toString(subtractArrays(array2, array3)));
        System.out.println(Arrays.toString(subtractArrays(array1, array3)));

        /* =================================================================================
         * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
         * и возвращающий новый массив, каждый элемент которого равен частному элементов
         * двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
         * как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
         * которое пользователь может увидеть - RuntimeException, т.е. ваше.
         */
        System.out.println(Arrays.toString(divideArrays(array1, array2)));
        System.out.println(Arrays.toString(divideArrays(array2, array3)));
        System.out.println(Arrays.toString(divideArrays(array1, array3)));
        System.out.println(Arrays.toString(divideArrays(array3, array1)));
    }

    public static int divide(int a, int b) {
        return a/b;
    }

    public static boolean compareNumbers() {
        Scanner prompt = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 10: ");
        int yourNumber = prompt.nextInt();
        int random = new Random().nextInt(0, 11);
        System.out.println("Random number is: " + random);
        System.out.print("Your number is larger than random: ");
        return (yourNumber > random);
    }

    public static int[] subtractArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Error. Both arrays must be of equal sizes.");
        }
        int[] result = new int[array1.length];

        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return result;
    }

    public static float[] divideArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new RuntimeException("Error. Both arrays must be of equal sizes.");
        }
        float [] result = new float[array1.length];

        for (int i = 0; i < array1.length; i++) {
            if (array2[i] == 0) {
                result[i] = array1[i];
            } else {
                result[i] = array1[i] / array2[i];
            }
        }
        return result;
    }

}
