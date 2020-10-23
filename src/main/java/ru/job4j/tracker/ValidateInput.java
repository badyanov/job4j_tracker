package ru.job4j.tracker;

/**
 * 1. Обеспечить бесперебойную работу приложения Tracker. [#285745]
 */
public class ValidateInput extends ConsoleInput {

    @Override
    public int askInt(Output out, String question) {
        boolean invalidInput = true;
        int result = -1;
        do {
            try {
                result = super.askInt(out, question);
                invalidInput = false;
            } catch (NumberFormatException e) {
                out.println("Incorrect input! Enter the number");
            }
        } while (invalidInput);
        return result;
    }
}
