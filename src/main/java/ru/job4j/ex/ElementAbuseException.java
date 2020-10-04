package ru.job4j.ex;

/**
 * 0.5. Иерархия исключений и множественный catch. [#285742]
 */
public class ElementAbuseException extends ElementNotFoundException {
    public ElementAbuseException(String message) {
        super(message);
    }
}
