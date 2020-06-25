package ru.job4j.oop;

public class User {
    private String name;
    private int age;

    public boolean canDrive() {
        boolean can = false;
        if (age >= 18) {
            can = true;
        }
        return can;
    }

    public static void main(String[] args) {
        User shkololo = new User();
        shkololo.age = 15;
        shkololo.name = "Барт Симпсон";

        System.out.println(shkololo.canDrive());
    }
}
