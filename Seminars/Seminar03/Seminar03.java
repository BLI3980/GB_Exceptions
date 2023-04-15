package Seminars.Seminar03;

import java.io.*;
import java.net.Inet4Address;

public class Seminar03 {
    public static void main(String[] args) throws FileNotFoundException, MyArraySizeException, MyArrayDataException {
        /*
        Task 01.
        Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
        внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
        можно было работать в блоке try-with-resources. Подумайте, что должно происходить
        при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
        При попытке вызвать add() у закрытого ресурса, должен выброситься IOException.
         */
//        try (Counter counter = new Counter();) {
//            counter.add();
//            counter.add();
//            System.out.println(counter);
//            counter.close();
//            counter.add();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        /*
        1. Создайте класс исключения, который будет выбрасываться при делении на 0.
        Исключение должно отображать понятное для пользователя сообщение об ошибке.
        2. Создайте класс исключений, которое будет возникать при обращении к пустому
        элементу в массиве ссылочного типа. Исключение должно отображать понятное для
        пользователя сообщение об ошибке
        3. Создайте класс исключения, которое будет возникать при попытке открыть
        несуществующий файл. Исключение должно отображать понятное для пользователя
        сообщение об ошибке.
         */

        // 1. ========================================================================
        // Option 1. Without separate method
//        int a = 10;
//        int b = 0;
//
//        try {
//            if (b == 0) {
//                throw new DivideByZeroException();
//            }
//            int c = a/b;
//        } catch (DivideByZeroException e) {
//            System.out.println(e.getMessage());
//        }

        // Option 2. With separate method
//        System.out.println(division(2,0));

        // 2. ========================================================================
        // Option 1. Without separate method
//        String[] array1 = new String[]{"dfdf", "adfnpn", "", "13415"};
//        String[] array2 = new String[]{"dfdf", "adfnpn", null, "13415"};
//
//        try {
//            String toPrint = array1[2];
//            if (toPrint.equals("")) {
//                throw new EmptyArrayElement();
//            }
//            System.out.println(toPrint);
//        } catch (EmptyArrayElement e) {
//            System.out.println(e.getMessage());
//        }

        // Option 2. With separate method
//        findInArray(array1, 2);

        // Option 3. With method for non-existent element of array
//        getElement(array2,5);
//        getElement(array2,2);

        // 3. ========================================================================
//        readFile("file.txt");

        /*
        1. Напишите метод,на вход которого подаётся двумерный строковый массив размером 4х4.
        При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
        2. Далее метод должен пройтись по всем элементам массива,преобразовать в int и
        просуммировать. Если в каком-то элементе массива преобразование не удалось (например,
        в ячейке лежит символ или текст вместо числа), должно быть брошено исключение
        MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
        3. В методе main() вызвать полученный метод, обработать возможные исключения
        MyArraySizeException и MyArrayDataException и вывести результат расчета (суммуэлементов,
        при условии, что подали на вход корректный массив).
         */
        String[][] array3 = new String[][]{
                                        {"1", "2", "3", "4", "5"},
                                        {"1", "2", "3", "4"},
                                        {"1", "2", "3", "4"},
                                        {"1", "2", "3", "4"}
        };
        System.out.println(cast4x4ArrayAndSum(array3));
//        try {
//            System.out.println(cast4x4ArrayAndSum(array3));
//        } catch (MyArraySizeException | MyArrayDataException e) {
//            System.out.println(e.getMessage());
//        }

    }

    public static int division(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a/b;
    }

    public static String findInArray(String[] array, int index) throws ElementException {
        if (array[index] == "") {
            throw new EmptyArrayElement();
        }
        return array[index];
    }

    public static <T> T getElement(T[] array, int index) throws EmptyArrayElement {
        if (index < 0 || index >=array.length) {
            throw new ElementException("Element with index [" + index +
                                        "] does not exist in the array");
        }
        if (array[index] == null) {
            throw new ElementException("Element with index [" + index +
                    "] is empty.");
        }
        return array[index];
    }

    public static void readFile(String fileName) throws NonExistentSource {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new NonExistentSource();
        }
    }

    public static int cast4x4ArrayAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int arraySize = 4;
        int sum = 0;
        if (array.length != arraySize) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != arraySize) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array[i].length; j++) {
                if (!isNumeric(array[i][j])) {
                    throw new MyArrayDataException("Cannot convert to integer. " +
                                                    "Element[" + i + "][" + j + "] " +
                                                    "contains unacceptable characters.");
                }
                sum += Integer.parseInt(array[i][j]);
            }
        }

        return sum;
    }

    private static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

}