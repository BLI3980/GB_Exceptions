package z_Temp;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//        System.out.println("str: " + str);
//        String[] str1 = str.split(" ");
//        System.out.println(str1[str1.length -1]);
////        int n = scanner.nextInt();
////        System.out.println("n: " + n);
//
////        String str = "Dfs";
////        System.out.println(isPropercase(str));
//
////        boolean isLetter = Character.isLetter('f');
////        System.out.println(isLetter);
//        char[] c = str1[0].toCharArray();
//        for (char symbol: c) {
//            if (!Character.isLetter(symbol)) {
//                System.out.println("false");
//            } else {
//                System.out.println("true");
//            }
//            break;
//        }
//        System.out.println("1st entry contains letters only: " + str1[0].matches("[a-zA-Z]+"));
//        String number = str1[1].replace(".", "");
//        System.out.println("2nd entry is: " + number);
//        System.out.println("2nd entry contains digits only: " + number.chars().allMatch(Character::isDigit));
//

        Date date = new Date();
        DateFormatter dateFormatter = new DateFormatter();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println(date);
        System.out.println(dateFormatter);
        System.out.println(dateFormat.format(date));

        System.out.println(isValidDate("36/12/2023"));

    }

    public static boolean isPropercase(String input) {
        boolean result = false;
        if (input.charAt(0) != input.toUpperCase().charAt(0)) {
            return result;
        }
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.toUpperCase().charAt(i)) {
                return result;
            }
        }
        result = true;
        return result;
    }

    private static boolean isValidDate(String input) {
        String formatString = "MM/dd/yyyy";

        try {
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            format.setLenient(false);
            format.parse(input);
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }





}
