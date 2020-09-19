package ru.job4j.tracker;

/**
 * 3. Интерфейс Input [#285722]
 * @author d.badyanov@outlook.com
 */
public interface Input {
    String askStr(Output out, String question);

    int askInt(Output out, String question);

    boolean askYesOrNo(Output out, String question);
}
