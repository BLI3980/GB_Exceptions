package Homework.Homework03.Model;

import Homework.Homework03.Config.Config;
import Homework.Homework03.View.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Checks {
    int amountOfFields = Config.AMOUNT_OF_FIELDS;

    /**
     * Method checks if provided by user information has required amount of fields
     * @param userInput user information
     * @return Method returns true if provided information is of correct amount
     * @throws RuntimeException if information is incomplete or contains extra fields the method throws an exception
     */
    public boolean isComplete(String userInput) throws IncompleteDataException{
        int length = userInput.split(" ").length;
        if (userInput.split(" ").length != amountOfFields) {
            throw new IncompleteDataException("Provided data is incomplete");
        } else {
            return true;
        }
    }

    /**
     * Method converts user input from string format into an array of strings
     * @param userInput user information
     * @return Method returns an array of strings, each element of which is a separate user information field
     */
    public String[] arrayOfInputs(String userInput) {
        return userInput.split(" ");
    }

    public boolean isCorrectEntry(String userInput) throws IncorrectInputFormatException {
        return true;
    }

    /**
     * A private method for use in another public method.
     * Method checks whether provided input contains only latin letters and nothing else.
     * @param name input data.
     * @return Method returns true, if provided data is correct, or false, if incorrect.
     */
    private static boolean isLatinLetter(String name) {
        return name.matches("[a-zA-z]+");
    }

    /**
     * A private method for use in another public method.
     * Method checks whether provided input string is in Title case, i.e. the first letter is upper case
     * and all subsequent letter are lower case.
     * @param name input data.
     * @return Method returns true, if provided data is correct, or false, if incorrect.
     */
    private static boolean isProperCase(String name) {
        boolean result = false;
        // The first letter must be upper case
        if (name.charAt(0) != name.toUpperCase().charAt(0)) {
            return result;
        }
        // All subsequent letters must be lower case
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) == name.toUpperCase().charAt(i)) {
                return result;
            }
        }
        result = true;
        return result;
    }

    /**
     * A private method for use in another public method.
     * Method checks whether provided input string is of "." characters and numbers only.
     * @param input input data.
     * @return Method returns true, if provided data is correct, or false, if incorrect.
     */
    private static boolean isNumeric(String input) {
        int check;
        try {
            for (int i = 0; i < input.length(); i++) {
                if ((i == 2 || i == 5)) continue;
                else check = Integer.parseInt(String.valueOf(input.charAt(i)));
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
//        return input.replace(".", "").chars().allMatch(Character::isDigit);
    }

    /**
     * A private method for use in another public method.
     * Method checks whether provided input string is of correct length.
     * @param input input data.
     * @param length required length.
     * @return Method returns true, if provided data is correct, or false, if incorrect.
     */
    private static boolean isCorrectLength(String input, int length) {
        return input.length() == length;
    }





    /**
     * Method checks whether provided first name, second name or patronymic name are of correct format.
     * I.e. input name contains only latin letters and is in Title case (the first letter is in upper case
     * and all subsequent letters are in lower case).
     * @param name input name.
     * @return Method returns true, if input name is of correct format.
     * @throws IncorrectInputFormatException Method throws an exception, if input name is of incorrect format.
     */
    public boolean isCorrectNameFormat(String name) throws IncorrectInputFormatException {
        if (!isLatinLetter(name)) {
            throw new IncorrectInputFormatException("Unacceptable symbols in \"" + name + "\". " +
                                                    "Only latin letters are accepted.");
        }
        if (!isProperCase(name)) {
            throw new IncorrectInputFormatException("Name, Surname and Patronymic names " +
                                                    "must start from capital letter followed by " +
                                                    "the rest of small letters.");
        }
        return true;
    }

    /**
     * Method checks whether provided date in string format is of correct format (dd.mm.yyyy).
     * @param date input date.
     * @return Method returns true, if input date is of correct format.
     * @throws IncorrectInputFormatException Method throws an exception, if input data is of incorrect format.
     */
    public boolean isCorrectDateFormat(String date) throws IncorrectInputFormatException {
        boolean containsDots = (date.charAt(2) == '.' && date.charAt(5) == '.');
        int dateLength = Config.DATE_LENGTH;

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

    /** Method checks whether provided date is a valid date and not in the future.
     * @param date input date.
     * @return Method returns true, if input date is valid.
     * @throws ParseException Method throws ParseException exception if provided date does not exist.
     * @throws InvalidDateException Method throws InvalidDateException if provided date is in future.
     */
    public boolean isValidBirthDate(String date) throws ParseException, InvalidDateException {
        String dateFormat = Config.DATE_FORMAT;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(date);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
            LocalDate birthday = LocalDate.parse(date,dateFormatter);
            if (LocalDate.now().isBefore(birthday)) {
                throw new InvalidDateException("Birthday cannot be in future.");
            }
        } catch (ParseException e) {
            throw new ParseException("Provided date does not exist.", 1);
        }
        return true;
    }

    /** Method checks whether provided phone string is of correct format.
     * @param phone input phone number.
     * @return Method returns true, if input phone number is of correct format.
     * @throws IncorrectInputFormatException Method throws an exception if provied phone number is of incorrect format.
     */
    public boolean isCorrectPhoneFormat(String phone) throws IncorrectInputFormatException {
        int phoneLength = Config.PHONE_LENGTH;
        if (!isNumeric(phone)) {
            throw new IncorrectInputFormatException("Phone number must contain only digits. " +
                                                    "For example: 12345678901.");
        }
        // Redundant check, since isNumeric won't accept minus sign.
//        if (Long.parseLong(phone) < 0) {
//            throw new IncorrectInputFormatException("The number must be unsigned, i.e. positive number.");
//        }
        if (!isCorrectLength(phone, phoneLength)) {
            throw new IncorrectInputFormatException("Either less or more than needed is typed in \""
                    + phone + "\'");
        }
        return true;
    }

    /**
     * Method checks whether provided gender is of correct format.
     * @param gender input gender
     * @return Method returns true, if input gender is of correct format.
     * @throws IncorrectInputFormatException Method throws an exception if provided gender is of incorrect format
     */
    public boolean isCorrectGenderFormat(String gender) throws IncorrectInputFormatException {
        int genderLength = Config.GENDER_LENGTH;
        boolean isLowerCase = gender.charAt(0) == gender.toLowerCase().charAt(0);
        if (!isLatinLetter(gender) || !isLowerCase || !isCorrectLength(gender, genderLength)
            || (gender.charAt(0) != 'm' && gender.charAt(0) != 'f')) {
            throw new IncorrectInputFormatException("Gender must be lowercase latin letter, " +
                                                    "either \"f\" or \"m\".");
        }
        return true;
    }
}
