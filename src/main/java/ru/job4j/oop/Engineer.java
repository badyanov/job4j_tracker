package ru.job4j.oop;

/**
 * 3. Реализация профессий в коде [#285779]
 * @author d.badyanov@outlook.com
 */
public class Engineer extends Profession {
    private Client customer;

    /**
     * Взять заказ
     * @param customer - заказчик
     */
    public void takeOrder(Client customer) {
        this.customer = customer;
    }

    /**
     * Сдать работу
     * @param customer - заказчик
     */
    public void submitOrder(Client customer) {
        this.customer = null;
    }

    /**
     * Думать как инженер
     */
    public void thinkAsEngineer() {
    }

    /**
     * Пить пиво
     * @param count - количество пива
     */
    public void drinkBeer(int count) {
    }
}
