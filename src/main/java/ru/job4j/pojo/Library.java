package ru.job4j.pojo;

/**
 * 3. Массивы и модели. [#285782]
 */
public class Library {
    public static void main(String[] args) {
        Book[] shelf = new Book[4];
        shelf[0] = new Book("Robert Martin", "Clean Code", 464);
        shelf[1] = new Book("Joshua Bloch", "Effective Java", 416);
        shelf[2] = new Book("Bruce Eckel", "Thinking in Java", 1520);
        shelf[3] = new Book("Herbert Schildt", "Java: The Complete Reference", 1248);

        System.out.println("\nВывод содержимого книжной полки:");
        printBooks(shelf);

        System.out.println("\nПереставить местами первую и последнюю книгу:");
        rearrangeBooks(shelf, 0, 3);
        printBooks(shelf);

        System.out.println("\nВывести все книги с названием \"Clean Code\"");
        printBooks(shelf, "Clean Code");
    }

    /**
     * Вывод всех книг
     * @param books - массив книг
     */
    private static void printBooks(Book[] books) {
        for (int index = 0; index < books.length; index++) {
            bookInfo(books[index], index);
        }
    }

    /**
     * Вывод книг с отбором по названию
     * @param books - массив книг
     * @param title - название книги для отбора
     */
    private static void printBooks(Book[] books, String title) {
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if (book.getTitle().equalsIgnoreCase(title)) {
                bookInfo(book, index);
            }
        }
    }

    /**
     * Переставить местами две книги
     * @param books - массив книг
     * @param first - индекс книги 1
     * @param second - индекс книги 2
     */
    private static void rearrangeBooks(Book[] books, int first, int second) {
        Book tmp = books[first];
        books[first] = books[second];
        books[second] = tmp;
    }

    /**
     * Вывод в консоль информации по книге с ее порядковым номером на полке
     * @param book - книга
     * @param index - порядковый номер
     */
    private static void bookInfo(Book book, int index) {
        System.out.printf("%d) %s (%s) - %d pages\n", index + 1, book.getTitle(), book.getAuthor(), book.getPages());
    }
}
