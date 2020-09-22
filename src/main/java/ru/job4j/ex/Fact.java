package ru.job4j.ex;

/**
 * 0.2. Кидаем исключение - throw new RuntimeException [#285739]
 */
public class Fact {
    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial cannot be computed for negative number");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Fact fact = new Fact();
        for (int i = 10; i >= -10; i--) {
            System.out.println(i + "! = " + fact.calc(i));
        }
    }
}
