package Homework.Homework03.Model;

public class Checks {
    int amountOfFields = 6;
    public boolean isComplete(String userInput) throws RuntimeException{
        int length = userInput.split(" ").length;
        if (userInput.split(" ").length != amountOfFields) {
            throw new RuntimeException();
        } else {
            return true;
        }
    }

    public String[] arrayOfInputs(String userInput) {
        return userInput.split(" ");
    }

    public boolean isCorrectEntry(String userInput) throws IncorrectInputFormatException {
        return true;
    }

    private static boolean isLatinLetter(String name) {
        return name.matches("[a-zA-z]+");
    }
    private static boolean isProperCase(String name) {
        boolean result = false;
        if (name.charAt(0) != name.toUpperCase().charAt(0)) {
            return result;
        }
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) == name.toUpperCase().charAt(i)) {
                return result;
            }
        }
        result = true;
        return result;
    }
    private static boolean isNumeric(String input) {
        return input.replace(".", "").chars().allMatch(Character::isDigit);
    }
    private static boolean isCorrectLength(String input, int length) {
        return input.length() == length;
    }



    public boolean isCorrectNameFormat(String name) throws IncorrectInputFormatException {
        if (!isLatinLetter(name)) {
            throw new IncorrectInputFormatException("Unacceptable symbols in \"" + name + "\"");
        }
        if (!isProperCase(name)) {
            throw new IncorrectInputFormatException("Name, Surname and Patronymic names " +
                                                    "must start from capital letter followed by " +
                                                    "the rest of small letters.");
        }
        return true;
    }

    public boolean isCorrectDateFormat(String date) throws IncorrectInputFormatException {
//        boolean isCorrectLength = date.length() == 10;
//        boolean isNumeric = date.replace(".", "").chars().allMatch(Character::isDigit);
        boolean containsDots = (date.charAt(2) == '.' && date.charAt(5) == '.');

        int dateLength = 10; // TO-DO: should really put such variable outside somewhere in configs.
        if (!isCorrectLength(date, dateLength)) {
            throw new IncorrectInputFormatException("Either less or more than needed is typed in \""
                                                    + date + "\'");
        }
        if (!containsDots) {
            throw new IncorrectInputFormatException("Date format must use dots as separators, " +
                                                    "i.e. dd.mm.yyyy");
        }
        if (!isNumeric(date)) {
            throw new IncorrectInputFormatException("Date must contain only digits separated by " +
                                                    "dots. For example: 01.01.1900");
        }
        return true;
    }

    public boolean isCorrectPhoneFormat(String phone) throws IncorrectInputFormatException {
        int phoneLength = 11; // TO-DO: should really put such variable outside somewhere in configs.
        if (!isNumeric(phone)) {
            throw new IncorrectInputFormatException("Phone number must contain only digits. " +
                                                    "For example: 12345678901");
        }
        if (!isCorrectLength(phone, phoneLength)) {
            throw new IncorrectInputFormatException("Either less or more than needed is typed in \""
                    + phone + "\'");
        }
        return true;
    }

    public boolean isCorrectGenderFormat(String gender) throws IncorrectInputFormatException {
        int genderLength = 1;
        boolean isLowerCase = gender.charAt(0) == gender.toLowerCase().charAt(0);
        if (!(isLatinLetter(gender) || isLowerCase || isCorrectLength(gender, genderLength))) {
            throw new IncorrectInputFormatException("Gender must is lowercase latin letters, " +
                                                    "either \"f\" or \"m\".");
        }
        return true;
    }
}
