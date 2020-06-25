package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    /**
     * 2. Перегрузка конструктора. [#285775] - конструктор без параметров
     */
    public Item() {
        this.id = 0;
        this.name = "<default name>";
    }

    /**
     * 2. Перегрузка конструктора. [#285775] - конструктор с одним параметром
     * @param id - идентификатор
     */
    public Item(int id) {
        this.id = id;
        this.name = "<default name>";
    }

    /**
     * 2. Перегрузка конструктора. [#285775] - конструктор с двумя параметрами
     * @param id - идентификатор
     * @param name - имя
     */
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}