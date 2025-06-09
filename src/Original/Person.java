package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Person implements BalanceObserver {
    private String IBAN;
    private String cardNumber;
    private String name;
    private String surname;
    private Integer balance;
    private Integer limit;

    public Person(String IBAN, String cardNumber, String name, String surname, Integer balance, Integer limit) {
        this.IBAN = IBAN;
        this.cardNumber = cardNumber;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.limit = limit;
    }

    // Getters & Setters
    public String getIBAN() { return IBAN; }
    public String getCardNumber() { return cardNumber; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public Integer getBalance() { return balance; }
    public void setBalance(Integer balance) { this.balance = balance; }
    public Integer getLimit() { return limit; }

    @Override
    public void update() {
        if (balance < limit) {
            System.out.println(name + " " + surname + ", ramai fara bani, saracule!");
        }
    }

    public boolean payBy(PaymentStrategy strategy, Integer amount) {
        if (balance >= amount) {
            strategy.pay(amount);
            return true;
        } else {
            System.out.println(name + " " + surname + ", pleaca de aici, saracule!");
            return false;
        }
    }
}
