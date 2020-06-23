package ru.job4j.oop;

/**
 * 1.7. Состояние объекта. [#285769]
 * Подзарядка одной батареи от другой
 * @author d.badyanov@outlook.com
 */
public class Battery {
    /**
     * Если true значит батарея при подзарадке отдает весь заряд и может заряжать > 100%
     */
    private static final boolean OVERLOADING = true;
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public static void printStatus(Battery ... batteries) {
        String status = "";
        for (int i = 0; i < batteries.length; i++) {
            status += "Battery " + (i + 1) + ": " + batteries[i].load + "%; ";
        }
        System.out.println(status);
    }

    /**
     * метод должен списывать заряд из батареи у кого вызывали метод exchange и добавить к объекту another
     * заряд батареи не может быть больше 100%
     * @param another Battery
     */
    public void exchange(Battery another) {
        int delta = Math.min(100 - another.load, this.load);
        if (Battery.OVERLOADING) {
            delta = this.load;
        }
        this.load = this.load - delta;
        another.load = another.load + delta;
    }

    public static void main(String[] args) {
        Battery first = new Battery(85);
        Battery second = new Battery(30);
        printStatus(first, second);

        first.exchange(second);
        printStatus(first, second);
    }
}
