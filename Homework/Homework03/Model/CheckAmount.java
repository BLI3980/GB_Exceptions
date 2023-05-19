package Homework.Homework03.Model;

public class CheckAmount {
    int amountOfFields = 6;
    public boolean isComplete(String userInput) {
        int length = userInput.split(" ").length;
        if (userInput.split(" ").length != amountOfFields) {
            return false;
        } else {
//            System.out.println("Length: " + length);
            return true;
        }

    }


}
