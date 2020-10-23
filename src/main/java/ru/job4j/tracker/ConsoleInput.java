package ru.job4j.tracker;

import java.util.Scanner;

/**
 * 4.1. Разрыв зависимости StartUI от Scanner. [#285726]
 *
 * @author d.badyanov@outlook.com
 */
public class ConsoleInput implements Input {
    private Scanner con = new Scanner(System.in);

    @Override
    public String askStr(Output out, String question) {
        out.print(question);
        return con.nextLine();
    }

    /**
     * Ввод целого неотрицательного числа с консоли
     *
     * @param question - подсказка ввода, которая будет выведена в строке ввода
     * @return введенное число. Обработка ошибок ввода не предусмотрена!
     */
    @Override
    public int askInt(Output out, String question) {
        return Integer.parseInt(askStr(out, question));
    }

    public boolean askYesOrNo(Output out, String question) {
        while (true) {
            String answer = askStr(out, question + " (Y/N?): ");
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }
}
