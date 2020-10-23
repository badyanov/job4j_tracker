package ru.job4j.tracker;

/**
 * 2. Рефакторинг - Шаблон Декоратор для валидатора. [#285736]
 */
public class ValidateInput extends ConsoleInput {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(Output out, String question) {
        return in.askStr(out, question);
    }

    @Override
    public int askInt(Output out, String question) {
        boolean invalidInput = true;
        int result = -1;
        do {
            try {
                result = in.askInt(out, question);
                invalidInput = false;
            } catch (NumberFormatException e) {
                out.println("Incorrect input! Enter the number");
            }
        } while (invalidInput);
        return result;
    }

    @Override
    public boolean askYesOrNo(Output out, String question) {
        return in.askYesOrNo(out, question);
    }
}
