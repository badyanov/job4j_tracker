package ru.job4j.tracker;

import javax.management.BadAttributeValueExpException;

/**
 * 3. Интерфейс Input [#285722]
 * @author d.badyanov@outlook.com
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);

    boolean askYesOrNo(String question);
}
