package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * 2. Рефакторинг - Шаблон Декоратор для валидатора. [#285736]
 */
public class ValidateInputTest {

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"24"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt(out, "Enter menu:");
        assertThat(selected, is(24));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt(out, "Any number:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputCheckOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"Any number", "12345"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int anyNumber = input.askInt(out, "Any number:");
        out.println(anyNumber);
        assertThat(out.toString(), Is.is(
                String.format(
                        "Incorrect input! Enter the number%n"
                        + "12345%n"
                )
        ));
    }

}