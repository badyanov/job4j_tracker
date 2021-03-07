package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * 3. Optional в банковских переводах. [#285575]
 */
public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(s -> s.getAccount().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        if (a.isEmpty()) {
            return Optional.empty();
        }
        return students.get(a.get())
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
