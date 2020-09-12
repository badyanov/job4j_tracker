package ru.job4j.tracker;

import java.util.Scanner;

/**
 * 4.1. Разрыв зависимости StartUI от Scanner. [#285726]
 * @author d.badyanov@outlook.com
 */
public class ConsoleInput implements Input {
    private Scanner con = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return con.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
