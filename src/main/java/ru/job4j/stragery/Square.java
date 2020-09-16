package ru.job4j.stragery;

/**
 * 7. Шаблон проектирования - Стратегия. [#285733]
 */
public class Square implements Shape {
    @Override
    public String draw() {
        final String EOL = System.lineSeparator();
        return " _____ " + EOL +
               "|     |" + EOL +
               "|     |" + EOL +
               "|_____|";
    }
}
