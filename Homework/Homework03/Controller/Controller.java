package Homework.Homework03.Controller;

import Homework.Homework03.DB.SaveToFile;
import Homework.Homework03.Model.Checks;
import Homework.Homework03.Model.IncompleteDataException;
import Homework.Homework03.Model.IncorrectInputFormatException;
import Homework.Homework03.Model.InvalidDateException;
import Homework.Homework03.View.View;

import java.text.ParseException;

public class Controller {
    private final View view = new View();
    private final Checks checks = new Checks();
    private final SaveToFile saveUserDetails = new SaveToFile();
    public void run() {
        view.intro();
        String userDetails = view.getUserDetails();
        try {
            System.out.println("Data entry is complete: " + checks.isComplete(userDetails));
            String[] array = userDetails.split(" ");
            System.out.println("Surname entry format is correct: " + checks.isCorrectNameFormat(array[0]));
            System.out.println("Name entry format is correct: " + checks.isCorrectNameFormat(array[1]));
            System.out.println("Patronymic name entry format is correct: " + checks.isCorrectNameFormat(array[2]));
            System.out.println("Date entry format is correct: " + checks.isCorrectDateFormat(array[3]));
            System.out.println("Date entry is valid date: " + checks.isValidBirthDate(array[3]));
            System.out.println("Phone entry format is correct: " + checks.isCorrectPhoneFormat(array[4]));
            System.out.println("Gender entry format is correct: " + checks.isCorrectGenderFormat(array[5]));
            saveUserDetails.saveToTxt(array);
        } catch (IncompleteDataException e) {
            view.dataIncomplete();
        } catch (IncorrectInputFormatException | ParseException | InvalidDateException e) {
            System.out.println(e);
        }
    }
}
