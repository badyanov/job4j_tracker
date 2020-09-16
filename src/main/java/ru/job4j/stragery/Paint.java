package ru.job4j.stragery;

/**
 * 7. Шаблон проектирования - Стратегия. [#285733]
 */
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Square());
        context.draw(new Triangle());
    }
}
