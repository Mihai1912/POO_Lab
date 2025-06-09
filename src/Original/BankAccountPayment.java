package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class BankAccountPayment implements PaymentStrategy {
    private final Person person;

    public BankAccountPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        person.setBalance(person.getBalance() - amount);
        System.out.println(person.getName() + " " + person.getSurname() +
                " a platit prin transfer bancar din contul " + person.getIBAN() +
                ", suma de " + amount + " RON");
    }
}
