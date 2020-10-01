package ru.job4j.ex;

/**
 * 0.4. Пользовательские исключения. [#285741]
 */
public class UserInputException extends Exception {
    public UserInputException(String message) {
        super(message);
    }
}
