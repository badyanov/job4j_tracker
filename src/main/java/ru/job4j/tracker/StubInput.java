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
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }

    @Override
    public boolean askYesOrNo(String question) {
        String answer = answers[position++];
        if (answer.equalsIgnoreCase("Y")) {
            return true;
        } else if (answer.equalsIgnoreCase("N")) {
            return false;
        } else {
            System.out.println("Incorrect input!");
            return false;
        }
    }
}
