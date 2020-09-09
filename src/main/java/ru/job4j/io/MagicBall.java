package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

/**
 * 1. Чтение из консоли. Класс Scanner. [#285720]
 * @author d.badyanov@outlook.com
 */
public class MagicBall {
    static final String textIntro = """
            Представь, если бы у тебя оказался Волшебный Шар, который знает все во Вселенной!
            Но этот шар оказался в минимальной комплектации. И на любой из твоих вопросов вариантов ответов у него
            только два - это варианты ДА или НЕТ.
            И вот, Шар перед тобой. Ты можешь задать вопрос и получишь ответ...
            Какой вопрос ты бы задал? Напиши ответ и нажми Enter""";

    public static void main(String[] args) {
        System.out.println(textIntro);
        Scanner con = new Scanner(System.in);
        con.nextLine();

        System.out.println(getRandomAnswer());
    }

    private static String getRandomAnswer() {
        String[] answers = {"Да", "Нет", "Может быть"};
        int answerIndex = new Random().nextInt(3);
        return answers[answerIndex];
    }
}
