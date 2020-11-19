package ru.job4j.pojo;

import java.util.Date;

/**
 * 2. Модель данных. [#285781]
 */
public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Дмитрий Бадьянов");
        license.setModel("Ford");
        license.setCode("xx111x");
        license.setCreated(new Date());

        System.out.printf("%s has a car - %s : %s created on %s%n",
                license.getOwner(), license.getModel(), license.getCode(), license.getCreated());
    }
}
