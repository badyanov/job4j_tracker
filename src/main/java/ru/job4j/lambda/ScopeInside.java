package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * 4. Зона видимости в лямбда и исключения [#285553]
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4, 5};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            final int num = number[i];
            final int subtotal = total;
            total = add(
                    () -> subtotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
