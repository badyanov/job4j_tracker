package ru.job4j.ex;

/**
 * 0. Что такое исключение. [#285746]
 */
public class FrequentEx {
    public static void main(String[] args) {
        String[] shops = {"Магнит", "Дикси", "Пятерочка"};
        for (String shop : shops) {
            System.out.println(shop);
        }
    }
}
