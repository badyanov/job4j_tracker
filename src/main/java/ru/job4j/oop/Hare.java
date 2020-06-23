package ru.job4j.oop;

public class Hare {
    private boolean canEat = false;

    public Hare(boolean canEat) {
        this.canEat = canEat;
    }

    public boolean tryEat(Ball ball) {
        System.out.println(this.getClass().getSimpleName() + " пытается съесть Колобка...");
        return this.canEat;
    }
}
