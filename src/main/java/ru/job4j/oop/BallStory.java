package ru.job4j.oop;

/**
 * 1.6. Взаимодействие объектов. [#285767]
 * @author d.badyanov@outlook.com
 */
public class BallStory {
    public static void main(String[] args) {
        boolean ballIsDied = true;
        Ball ball = new Ball();
        Hare hare = new Hare(false);
        Wolf wolf = new Wolf(false);
        Fox fox = new Fox(true);

        ballIsDied = hare.tryEat(ball);
        System.out.println(ballIsDied);
        ballIsDied = wolf.tryEat(ball);
        System.out.println(ballIsDied);
        ballIsDied = fox.tryEat(ball);
        System.out.println(ballIsDied);

        if (ballIsDied) {
            System.out.println("Вот и сказке конец, а кто слушал - молодец");
        } else {
            System.out.println("Продолжение следует...");
        }
    }
}
