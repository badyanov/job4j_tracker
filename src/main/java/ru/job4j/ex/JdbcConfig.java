package ru.job4j.ex;

/**
 * 0.4. Пользовательские исключения. [#285741]
 */
public class JdbcConfig {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("URL cannot be null");
        }
        System.out.printf("Connected to %s successful.%n", url);
    }

    public static void main(String[] args) {
        try {
            load("jdbc://localhost:5432/");
            load(null);
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}
