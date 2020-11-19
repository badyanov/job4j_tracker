package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("The bus is on the route...");
    }

    @Override
    public void passengers(int quantity) {
        System.out.printf("There are %d passengers in the bus" + System.lineSeparator(), quantity);
    }

    @Override
    public int refuelAndGetPrice(int amountLiters) {
        final String EOL = System.lineSeparator();
        int price = 48 * amountLiters;
        System.out.printf("The bus has refueled for %d liters. Checkout %d rub." + EOL,
                amountLiters, price);
        return price;
    }

    public static void main(String[] args) {
        Bus bus = new Bus();
        bus.refuelAndGetPrice(100);
        bus.passengers(30);
        bus.drive();
    }
}
