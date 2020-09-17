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

    /**
     * Ввод целого неотрицательного числа с консоли
     * @param question - подсказка ввода, которая будет выведена в строке ввода
     * @return введенное корректное число, либо -1 в любом другом случае
     */
    @Override
    public int askInt(String question) {
        int result = -1;
        try {
            result = Integer.parseInt(askStr(question));
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input! Enter the number");
        }
        return (result >= 0) ? result : -1;
    }

    public boolean askYesOrNo(String question) {
        while (true) {
            String answer = askStr(question + " (Y/N?): ");
            if (answer.equalsIgnoreCase("Y")) {
                return true;
            } else if (answer.equalsIgnoreCase("N")) {
                return false;
            }
        }
    }
}
