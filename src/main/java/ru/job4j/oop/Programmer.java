package ru.job4j.oop;

/**
 * 3. Реализация профессий в коде [#285779]
 * Класс "Программист"
 * @author d.badyanov@outlook.com
 */
public class Programmer extends Engineer {
    private String programmingLanguage;
    private String level;

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * Описание первой половины деятельности программиста
     */
    public void copyCodeFromStackoverflow() {
    }

    /**
     * Описание второй половины деятельности программиста
     */
    public void pasteCodeFromStackoverflow() {
    }
}