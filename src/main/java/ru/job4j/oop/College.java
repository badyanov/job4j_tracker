package ru.job4j.oop;

/**
 * 3.1. Приведение типов. Повышение типа и понижение типа. [#285725]
 */
public class College {
    public static void main(String[] args) {
        System.out.println("Новый первокурсник");
        Freshman freshBlood = new Freshman();
        System.out.println(freshBlood.getClass());
        System.out.println(freshBlood instanceof Freshman);
        System.out.println(freshBlood instanceof Student);
        System.out.println(freshBlood instanceof Object);
        System.out.println();

        System.out.println("Апкаст до типа Student");
        Student someStudent = freshBlood;
        System.out.println(someStudent.getClass());
        System.out.println(someStudent instanceof Freshman);
        System.out.println(someStudent instanceof Student);
        System.out.println(someStudent instanceof Object);
        System.out.println();

        System.out.println("Апкаст до базового типа Object");
        Object someObject = someStudent;
        System.out.println(someObject.getClass());
        System.out.println(someObject instanceof Freshman);
        System.out.println(someObject instanceof Student);
        System.out.println(someObject instanceof Object);
        System.out.println();

        System.out.println("Даункаст Студента до Первокурсника");
        Freshman stillFreshman = (Freshman) someStudent;
        System.out.println(stillFreshman.getClass());
        System.out.println(stillFreshman instanceof Freshman);
        System.out.println(stillFreshman instanceof Student);
        System.out.println(stillFreshman instanceof Object);
    }
}
