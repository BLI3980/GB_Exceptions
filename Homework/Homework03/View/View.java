package Homework.Homework03.View;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    /*
     User interaction methods
     */

    public void intro() {
        separator();
        System.out.println("WELCOME TO USER DETAILS HANDLING PROGRAM.");
        System.out.println("The following input details are required for this program:" +
                "1. First name;" +
                "2. Second name;" +
                "3. Patronymic name;" +
                "4. Date of birth (format: dd.mm.yyyy);" +
                "5. Phone number (format: 12345678901);" +
                "6. Gender (format: F/M).");
        System.out.println("The details can be entered in any order, but must be separated by space.");
        separator();
    }

    public String getUserDetails() {
        String userInput = prompt("Please enter the details here: ");
        return userInput;
    }

    public String prompt(String message) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }

    public void separator() {
        for (int i = 0; i < 75; i++) {
            System.out.print("-");
        }
    }

//    public String[] fields() {
//        String[] fields = new String[]{
//                "Enter the first name: ",
//                "Enter the second name: ",
//                "Enter the patronymic name: ",
//                "Enter the date of birth: ",
//                "Enter the phone number: ",
//                "Enter the gender: "
//        };
//        return fields;
//    }
}
