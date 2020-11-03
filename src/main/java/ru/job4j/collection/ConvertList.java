package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. Конвертация листа массивов в один лист Integer [#285703]
 */
public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] array : list) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}