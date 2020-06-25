package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.Test;

import java.util.Date;

/**
 * 4. Сравнение моделей. Метод equals [#285783]
 */
public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

    @Test
    public void eqAll() {
        Date date = new Date();
        License first = new License();
        first.setCode("audio");
        first.setOwner("Owner");
        first.setModel("Model");
        first.setCreated(date);
        License second = new License();
        second.setCode("audio");
        second.setOwner("Owner");
        second.setModel("Model");
        second.setCreated(date);
        assertThat(first, is(second));
    }

    @Test
    public void eqNameAndNotEqOwner() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("The same owner");
        License second = new License();
        second.setCode("audio");
        second.setOwner("Another owner");
        assertThat(first, not(second));
    }
}