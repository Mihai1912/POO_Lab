package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CardPayment implements PaymentStrategy {
    private final Person person;

    public CardPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        person.setBalance(person.getBalance() - amount);
        System.out.println(person.getName() + " " + person.getSurname() +
                " a platit cu cardul " + person.getCardNumber() + " suma de " + amount + " RON");
    }
}
