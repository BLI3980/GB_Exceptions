package Homework.Homework03.Model;

public class CheckAmount {
    int amountOfFields = 6;
    public void checkComleteness(String userInput) {

        if (userInput.split(" ").length != amountOfFields) {
            System.out.println("You have either missed something out or provided something extra." +
                    "\nPlease check at try again.");
        }
    }
}
