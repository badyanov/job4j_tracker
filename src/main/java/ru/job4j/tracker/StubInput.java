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
}
