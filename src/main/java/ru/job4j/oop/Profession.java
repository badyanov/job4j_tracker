package ru.job4j.oop;

/**
 * 3. Реализация профессий в коде [#285779]
 * @author d.badyanov@outlook.com
 */
public class Profession {
    private boolean hired;
    private boolean working;
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * Начало рабочего дня
     */
    public void beginWorking() {
        this.working = true;
    }

    /**
     * Конец рабочего дня
     */
    public void endWorking() {
        this.working = false;
    }

    /**
     * Нанять сотрудника на работу
     */
    public void hire(int salary) {
        this.hired = true;
        this.salary = salary;
    }

    /**
     * Уволить сотрудника
     */
    public void dismiss() {
        this.hired = false;
        this.salary = 0;
    }
}
