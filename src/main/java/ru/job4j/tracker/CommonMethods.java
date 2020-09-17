package ru.job4j.tracker;

public class CommonMethods {
    // Так как метод showItems использовался у меня в нескольких местах, вывел его в отдельный класс
    // Не придумал, как это лучше реализовать в данном случае
    public static void showItems(Item[] items) {
        System.out.println("There are " + items.length + " items:");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Item item : items) {
            System.out.printf("| %-2d | %-100s |" + System.lineSeparator(), item.getId(), item.getName());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    }
}
