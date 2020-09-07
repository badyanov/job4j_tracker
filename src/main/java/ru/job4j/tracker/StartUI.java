package ru.job4j.tracker;

import java.util.Arrays;

/**
 * 5. Tracker - хранилище [#285788]
 */
public class StartUI {
    public static void main(String[] args) {
        // 5. Tracker - хранилище [#285788]
        Tracker tracker = new Tracker();

        tracker.add(new Item("Запустить трекер"));
        tracker.add(new Item("Проверить работу трекера"));
        tracker.add(new Item("Проверить работу поиска по ID"));

        System.out.println("\t1. Все элементы:");
        System.out.println(Arrays.toString(tracker.findAll()));

        System.out.println("\t2. Поиск по id = 2:");
        System.out.println(tracker.findById(2));

        System.out.println("\t3. Поиск по name = \"Запустить трекер\":");
        System.out.println(Arrays.toString(tracker.findByName("Запустить трекер")));

        System.out.println("\t4. Поиск по name = \"Нет такой задачи\":");
        System.out.println(Arrays.toString(tracker.findByName("Нет такой задачи")));

        // 6. Метод замены заявки. Tracker.replace [#285785]
        System.out.println("\t5. Замена заявки:");
        tracker.replace(2, new Item("Заменить заявку с id = 2"));
        System.out.println(Arrays.toString(tracker.findAll()));
    }
}
