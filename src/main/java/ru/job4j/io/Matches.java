package ru.job4j.io;

import java.util.Date;
import java.util.Scanner;

/**
 * 2. Scanner и чтение числа из консоли. [#285721]
 * Игра "11"
 * @author d.badyanov@outlook.com
 */
public class Matches {
    private int matchesLeft;
    private int playerIndex;
    private String[] players = new String[2];

    public void startNewGame() {
        matchesLeft = 11;
        playerIndex = 0;
        players[0] = "Первый игрок";
        players[1] = "Второй игрок";
        System.out.println("Каждый игрок по очереди тянет 1, 2 или 3 спички.");
        System.out.println("Побеждает тот, кто забрал последние.");
        System.out.printf("<< %tT: Начало игры >>\n", new Date());
        startGameProcess();
    }

    private void startGameProcess() {
        Scanner con = new Scanner(System.in);
        String playerName = "";
        while (checkFinish()) {
            playerName = players[playerIndex];
            System.out.printf("Ходит %s:\n", playerName);
            int amount = inputAmountAndCheckResult(con);
            if (amount != 0) {
                makeTurn(amount);
                printState();
            }
        }
        System.out.printf("<< %tT: Игра окончена. Победил %s!\n", new Date(), playerName);
    }

    private int inputAmountAndCheckResult(Scanner con) {
        int amount = 0;
        try {
            amount = Integer.parseInt(con.nextLine());
        } catch (NumberFormatException ignored) {
        }
        if (amount > matchesLeft) {
            amount = 0;
            System.out.println("Столько спичек даже нету, не жульничай!");
        } else if ((amount < 1) || (amount > 3)) {
            amount = 0;
            System.out.println("Некорректное значение. Введите число 1, 2 или 3.");
        } else {
            System.out.println("Ход принят.");
        }
        return amount;
    }

    private boolean checkFinish() {
        return matchesLeft > 0;
    }

    private void makeTurn(int amount) {
        matchesLeft -= amount;
        playerIndex = playerIndex == 0 ? 1 : 0;
    }

    private void printState() {
        System.out.printf("На столе осталось %d спичек.\n", matchesLeft);
    }

    public static void main(String[] args) {
        Matches game = new Matches();
        game.startNewGame();
    }
}