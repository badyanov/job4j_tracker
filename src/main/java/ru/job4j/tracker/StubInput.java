package ru.job4j.tracker;

/**
 * 5. Input и полиморфизм. [#285724]
 * класс используется для подмены ввода с консоли в тестах
 */
public class StubInput implements Input {
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String askStr(Output out, String question) {
        return answers[position++];
    }

    @Override
    public int askInt(Output out, String question) {
        return Integer.parseInt(askStr(out, question));
    }

    @Override
    public boolean askYesOrNo(Output out, String question) {
        String answer = answers[position++];
        if (answer.equalsIgnoreCase("Y")) {
            return true;
        } else if (answer.equalsIgnoreCase("N")) {
            return false;
        } else {
            out.println("Incorrect input!");
            return false;
        }
    }
}
