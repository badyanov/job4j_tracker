package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 4. Преобразование List в Map. [#285566]
 */
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    public Map<String, Student> map(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        s -> s.getSurname(),
                        s -> s,
                        (s1, s2) -> s1
                ));
    }
}
