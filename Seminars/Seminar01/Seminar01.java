package Seminars.Seminar01;

import java.util.Arrays;
import java.util.Random;

public class Seminar01 {
    public static void main(String[] args) {
        /*
         Task:Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
         Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
            1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
            2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
            3. если вместо массива пришел null, метод вернет -3
            4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
        Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое
        число у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат
        пользователю. Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
         */

        int[] array1 = new int[] {7, 15, 10, 4};
        int[] array2 = new int[] {9, 3, 6, 23, 17};

        try {
//            System.out.println(findValue(array1, 4));
//            System.out.println(findValue(array2, 18));
//            System.out.println(findValue(null, 4));
            System.out.println(findValue(array2, 23));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        /*
        Same as before but for two-dimentional array ==========================
         */
        System.out.println("Array3:");
        int[][] array3 = fillAndPrint2DArray(2, 2);
        System.out.println("Array4:");
        int[][] array4 = fillAndPrint2DArray(4, 4);
        System.out.println("Array5:");
        int[][] array5 = array4;
        for (int[] a: array5) {
            for (int b: a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
        System.out.println("Array6:");
        int[][] array6 = fillAndPrint2DArray(4, 5);

        try {
//            findValue2D(array3, 18); // Error code: -1. Array length less than minimum required.
//            findValue2D(array4, 18); // Error code: -2. Value not found.
//            findValue2D(null, 18); // Error code: -3. Array does not contain any values as it is null.
//            findValue2D(array6, 1); // Error conde: -4. Array dimensions must be equal.
//            findValue2D(array5, 2); // Error code: -5. Unacceptable array value. Can be either 1 or 0
            findValue2D(array5, 1); // The index of 2 is [0][0]
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    public static int findValue(int[] array, int value) throws Exception {
        int minLength = 5;
        int result = -2;
        if (array == null) {
            throw new RuntimeException("Error code: -3. Array does not contain any values as it is null.");
        }
        if (array.length < minLength) {
            throw new RuntimeException("Error code: -1. Array length less than minimum required.");
        }
        else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    result = i; // return index of found value
                    break;
                }
            }
        }
        if (result == -2) {
            throw new RuntimeException("Error code: -2. Value not found.");
        }
        return result;
    }

    public static void findValue2D(int[][] array, int value) throws Exception {
        int result = -2;
        int minLength = 3;
        if (array == null) {
            throw new RuntimeException("Error code: -3. Array does not contain any values as it is null.");
        }
        if (array.length < minLength && array[0].length < minLength) {
            throw new RuntimeException("Error code: -1. Array length less than minimum required.");
        }
        if (array.length != array[0].length) {
            throw new RuntimeException("Error conde: -4. Array dimensions must be equal.");
        }
        else {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] > 1 || array[i][j] < 0) {
                        throw new RuntimeException("Error code: -5. Unacceptable array value. Can be either 1 or 0");
                    }
                    if (array[i][j] == value) {
                        System.out.printf("The index of %d is [%d][%d]", value, i, j);
                        result = 1;
                        break;
                    }

                }
                if (result == 1) {
                    break;
                }
            }
        }
        if (result == -2) {
            throw new RuntimeException("Error code: -2. Value not found.");
        }

    }

    public static int[][] fillAndPrint2DArray(int dimension1, int dimension2) {
        int[][] array = new int[dimension1][dimension2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Random().nextInt(0, 2);
            }
        }
        for (int[] a: array) {
            for (int b: a) {
                System.out.print(b + "\t");
            }
            System.out.println();
        }
        return array;
    }




}
