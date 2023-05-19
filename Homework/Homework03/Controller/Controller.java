package Homework.Homework03.Controller;

import Homework.Homework03.Model.CheckAmount;
import Homework.Homework03.View.View;

public class Controller {
    private final View view = new View();
    private final CheckAmount checkAmount = new CheckAmount();
    public void run() {
        view.intro();
        String userDetails = view.getUserDetails();
        while (!checkAmount.isComplete(userDetails)) {
            view.dataIncomplete();
            userDetails = view.getUserDetails();
//            if (!checkAmount.isComplete(userDetails)) {
//                view.dataIncomplete();
//            } else {
//                System.out.println("All good!");
//            }

        }

    }
}
