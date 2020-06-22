package ru.job4j.oop;

/**
 * 1.4. Вызов метод с возвращаемым типом. [#285768]
 * @author d.badyanov@outlook.com
 */
public class DummyDic {
    public String engToRus(String eng) {
        String result = "Неизвестное слово: " + eng;
        return result;
    }

    public static void main(String[] args) {
        DummyDic dict = new DummyDic();
        System.out.println(dict.engToRus("Cat"));
    }
}
