package Homework.Homework03.Controller;

import Homework.Homework03.Model.Checks;
import Homework.Homework03.Model.IncorrectInputFormatException;
import Homework.Homework03.View.View;

public class Controller {
    private final View view = new View();
    private final Checks checks = new Checks();
    public void run() {
        view.intro();
        String userDetails = view.getUserDetails();
//        while (!checkAmount.isComplete(userDetails)) {
//            view.dataIncomplete();
//            userDetails = view.getUserDetails();
////            if (!checkAmount.isComplete(userDetails)) {
////                view.dataIncomplete();
////            } else {
////                System.out.println("All good!");
////            }
//
//        }
        try {
            System.out.println("Data entry is complete: " + checks.isComplete(userDetails));
        } catch (RuntimeException e) {
            view.dataIncomplete();
            userDetails = view.getUserDetails();
        }
        String[] array = userDetails.split(" ");
        try {
            System.out.println("Name entry format is correct: " + checks.isCorrectNameFormat(array[0]));
        } catch (IncorrectInputFormatException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Date entry format is correct: " + checks.isCorrectDateFormat(array[1]));
        } catch (IncorrectInputFormatException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Phone entry format is correct: " + checks.isCorrectPhoneFormat(array[2]));
        } catch (IncorrectInputFormatException e) {
            System.out.println(e);
        }
        try {
            System.out.println("Gender entry format is correct: " + checks.isCorrectGenderFormat(array[3]));
        } catch (IncorrectInputFormatException e) {
            System.out.println(e);
        }



    }
}
