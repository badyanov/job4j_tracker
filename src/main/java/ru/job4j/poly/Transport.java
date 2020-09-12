package ru.job4j.poly;

/**
 * 3. Интерфейс Input [#285722]
 */
public interface Transport {
    void drive();

    void passengers(int quantity);

    int refuelAndGetPrice(int amountLiters);
}