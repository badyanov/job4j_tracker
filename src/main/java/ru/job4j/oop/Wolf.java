package ru.job4j.oop;

public class Wolf {
    private boolean canEat = false;

    public Wolf() {

    }
    public Wolf(boolean canEat) {
        this.canEat = canEat;
    }

    public void eat(Girl girl) {
        System.out.println("Волк съел Красную Шапочку");
    }

    public boolean tryEat(Ball ball) {
        System.out.println(this.getClass().getSimpleName() + " пытается съесть Колобка...");
        return this.canEat;
    }
}
