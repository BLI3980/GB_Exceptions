package Homework.Homework03.View;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    /*
     User interaction methods
     */

    public void intro() {
        separator();
        System.out.println("\tWELCOME TO USER DETAILS HANDLING PROGRAM.");
        System.out.println("The following input details are required for this program:\n" +
                "\t1. First name;\n" +
                "\t2. Second name;\n" +
                "\t3. Patronymic name;\n" +
                "\t4. Date of birth (format: dd.mm.yyyy);\n" +
                "\t5. Phone number (format: 12345678901);\n" +
                "\t6. Gender (format: F/M).\n");
        System.out.println("The details can be entered in any order, but must be separated by space.");
        separator();
    }

    public String getUserDetails() {
        String userInput = prompt("Please enter the details here below: \n");
        return userInput;
    }

    public void dataIncomplete() {
        attention();
        separator();
        System.out.println("You have either missed something out or provided something extra details." +
                "\nPlease check again and try again.");
        separator();
    }

    public String prompt(String message) {
        Scanner userInput = new Scanner(System.in);
        System.out.print(message);
        return userInput.nextLine();
    }

    private void attention() {
        System.out.println("\t\t\tATTENTION!");
    }

    public void separator() {
        for (int i = 0; i < 75; i++) {
            System.out.print("-");
        }
        System.out.println();
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
