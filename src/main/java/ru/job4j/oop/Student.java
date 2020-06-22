package ru.job4j.oop;

/**
 * 1.2. Вызов метода объекта [#285765]
 * @author d.badyanov@outlook.com
 */
public class Student {
    public void music() {
        System.out.println("Tra tra tra");
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.song();
        petya.song();
        petya.song();
    }
}
