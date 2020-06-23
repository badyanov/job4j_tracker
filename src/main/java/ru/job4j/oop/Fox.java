package ru.job4j.oop;

public class Fox {
    private boolean canEat = true;

    public Fox(boolean canEat) {
        this.canEat = canEat;
    }

    public boolean tryEat(Ball ball) {
        System.out.println(this.getClass().getSimpleName() + " пытается съесть Колобка...");
        return this.canEat;
    }
}
