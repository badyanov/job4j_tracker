package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * - [#285578]
 */
public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(subject -> subject.getScore())
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                        pupil.getSubjects().stream().mapToInt(subj -> subj.getScore()).average().orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(subject -> subject.getName(),
                        Collectors.averagingDouble(subject -> subject.getScore())))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                    pupil.getSubjects().stream().mapToInt(subj -> subj.getScore()).sum()))
                .max((t1, t2) -> Double.compare(t1.getScore(), t2.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(subject -> subject.getName(),
                        Collectors.summingDouble(subject -> subject.getScore())))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max((t1, t2) -> Double.compare(t1.getScore(), t2.getScore()))
                .orElse(null);
    }
}
