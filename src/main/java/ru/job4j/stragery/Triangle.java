package ru.job4j.stragery;

/**
 * 7. Шаблон проектирования - Стратегия. [#285733]
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        final String EOL = System.lineSeparator();
        return "_______" + EOL +
               "\\     /" + EOL +
               " \\   / " + EOL +
               "  \\ /  " + EOL +
               "   V   ";
    }
}
