package Homework.Homework02;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        /*
        1.
        Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и
        возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
        приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
         */
        getFloat();

        // 2. Если необходимо, исправьте данный код.
        try {
            System.out.print("Enter a Dividend: ");
            int a = new Scanner(System.in).nextInt();
            System.out.print("Enter a Divisor: ");
            int b = new Scanner(System.in).nextInt();
            double quotient = a / b;
            System.out.println("Quotient = " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero exception: " + e);
        }

        // 3. Дан следующий код, исправьте его там, где требуется.
        try {
            int a = 90;
            int b = 0;
            System.out.println(a / b);

            printSum(null, 234);

            int[] abc = { 1, 2 };
            abc[3] = 9;

        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

        /*
        4.
        Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
         */
        getUserEntry();


    }

    public static Float getFloat() {
        Float result = null;
        while (true) {
            try {
                System.out.print("Enter a decimal number: ");
                result = new Scanner(System.in).nextFloat();
                System.out.printf("You have entered %.2f. Good job!", result);
                return result;
            } catch (Exception e) {
                System.out.println("Incorrect input type. Try again.");
            }
        }
    }

    public static void printSum(Integer a, Integer b) {

        System.out.println(a + b);
    }

    public static String getUserEntry() {
        String result = null;
        while (true) {
            try {
                System.out.print("Type anything: ");
                result = new Scanner(System.in).nextLine();
                if (result.isBlank()) {
                    throw new RuntimeException("Entry is empty. Try again.");
                } else {
                    System.out.printf("Your entry is: \"%s\".", result);
                    return result;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
