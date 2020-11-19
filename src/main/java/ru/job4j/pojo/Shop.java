package ru.job4j.pojo;

/**
 * 3. Удаление моделей из массива. [#285784]
 */
public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        printProducts(products);

        System.out.println("\nИндекс первой пустой ячейки = " + indexOfNull(products));
    }

    /**
     * Поиск первой не заполненной ячейки продуктов
     * @param products - массив продуктов
     * @return индекс первой не пустой ячейки. Если не найдено, возвращает -1
     */
    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Вывод списка продуктов с проверкой на null
     * @param products - массив продуктов
     */
    private static void printProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                System.out.printf("| %-2d | %-12s | %4d |" + System.lineSeparator(), i, "", 0);
            } else {
                System.out.printf("| %-2d | %-12s | %4d |" + System.lineSeparator(),
                        i,
                        product.getName(),
                        product.getCount());
            }
        }
    }
}
