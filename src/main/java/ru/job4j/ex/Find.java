package ru.job4j.ex;

/**
 * 3. Замена if-else-throw на if-throw [#285737]
 */
public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }

    public static void main(String[] args) {
        String[] data = {"zero", "one", "two", "three"};
        for (int i = 0; i <= data.length; i++) {
            System.out.printf("data[%d] = %s%n", i, Find.get(data, i));
        }
    }
}
