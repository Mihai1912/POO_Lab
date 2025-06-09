package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class VoucherPayment implements PaymentStrategy {
    private final Person person;

    public VoucherPayment(Person person) {
        this.person = person;
    }

    @Override
    public void pay(Integer amount) {
        person.setBalance(person.getBalance() - amount);
        System.out.println(person.getName() + " " + person.getSurname() +
                " a platit folosind un voucher, suma de " + amount + " RON");
    }
}
