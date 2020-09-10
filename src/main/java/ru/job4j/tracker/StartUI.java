package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2.1. Реализация класса StartUI [#285731]
 */
public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            run = false;
        }
    }

    private void showMenu() {
        System.out.println("=== Tracker's Menu ===");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by ID");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit tracker");
        System.out.println("======================");
        System.out.print("Select: ");
    }

    public static void main(String[] args) {
        Scanner con = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(con, tracker);
    }
}
