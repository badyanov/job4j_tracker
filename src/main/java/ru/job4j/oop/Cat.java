package ru.job4j.oop;

/**
 * 1.5. Поля объекта [#285764]
 * @author d.badyanov@outlook.com
 */
public class Cat {
    private String food;
    private String name;

    public void show() {
        System.out.printf("There is a %s, and it's eat is a %s.\n", this.name, this.food);
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public String sound() {
       return "may-may";
    }

    public static void main(String[] args) {
        System.out.println("1. Testing for Gav:");
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveNick("Gav");
        gav.show();
        System.out.println("2. Testing for Black:");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Black");
        black.show();
    }
}
