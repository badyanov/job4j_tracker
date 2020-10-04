package ru.job4j.ex;

/**
 * 0.6. Error - исключения, связанные с работой виртуальной машины [#285743]
 */
public class FactRec {
    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The function argument must be a non-negative integer");
        }
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return calc(n - 1) * n;
        }
    }

    public static void main(String[] args) {
        int arg = 12;
        int rsl = calc(arg);
        System.out.printf("%d! = %d%n", arg, rsl);
    }
}
