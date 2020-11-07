package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * 3. Банковские переводы. [#285709]
 */
public class BankServiceTest {

    @Test
    public void addUser() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findByPassport("3434"), is(user1));
        assertThat(bank.findByPassport("7508"), is(user2));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("40817810570000123456", 1000000D));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));

        assertNull(bank.findByPassport("3456"));
    }

    @Test
    public void whenEnterInvalidRequisite() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("40817810570000123456", 1000000D));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));

        assertThat(bank.findByPassport(user1.getPassport()), is(user1));
        assertNull(bank.findByRequisite(user1.getPassport(), "11111111111111111111"));

        assertThat(bank.findByPassport(user2.getPassport()), is(user2));
        assertNull(bank.findByRequisite(user2.getPassport(), "11111111111111111111"));
    }

    @Test
    public void addAccount() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("40817810570000123456", 1000000D));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));

        assertThat(bank.findByRequisite("3434", "40817810570000123456").getBalance(), is(1000000D));
        assertThat(bank.findByRequisite("7508", "40817810570000555555").getBalance(), is(5000D));
    }

    @Test
    public void add2Accounts() {
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));
        bank.addAccount(user2.getPassport(), new Account("40817810570000888888", 8000D));
        bank.addAccount(user2.getPassport(), new Account("40817810570000888888", 1000D));

        assertThat(bank.findByRequisite("7508", "40817810570000555555").getBalance(), is(5000D));
        assertThat(bank.findByRequisite("7508", "40817810570000888888").getBalance(), is(8000D));
    }

    @Test
    public void transferMoneySuccess() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("40817810570000123456", 1000000D));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));
        bank.addAccount(user2.getPassport(), new Account("40817810570000888888", 20000D));
        boolean transferResult = bank.transferMoney("7508", "40817810570000888888",
                "3434", "40817810570000123456",
                15000D);

        assertThat(transferResult, is(true));
        assertThat(bank.findByRequisite("7508", "40817810570000888888").getBalance(), is(5000D));
        assertThat(bank.findByRequisite("3434", "40817810570000123456").getBalance(), is(1015000D));
    }

    @Test
    public void transferMoneyNotEnoughMoney() {
        User user1 = new User("3434", "Petr Arsentev");
        User user2 = new User("7508", "Dmitriy Badyanov");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("40817810570000123456", 1000000D));
        bank.addUser(user2);
        bank.addAccount(user2.getPassport(), new Account("40817810570000555555", 5000D));
        bank.addAccount(user2.getPassport(), new Account("40817810570000888888", 20000D));
        boolean transferResult = bank.transferMoney("7508", "40817810570000555555",
                "3434", "40817810570000123456",
                15000D);

        assertThat(transferResult, is(false));
        assertThat(bank.findByRequisite("7508", "40817810570000555555").getBalance(), is(5000D));
        assertThat(bank.findByRequisite("3434", "40817810570000123456").getBalance(), is(1000000D));
    }
}