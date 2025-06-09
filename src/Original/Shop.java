package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Shop implements TransactionPublisher {
    private final Random priceGenerator = new Random(56);
    private final RandomPaymentFactory paymentFactory = new RandomPaymentFactory();
    private final ArrayList<Person> customers = new ArrayList<>();

    public void addCustomers(List<Person> customers) {
        this.customers.addAll(customers);
    }

    public ArrayList<Person> getCustomers() {
        return customers;
    }

    @Override
    public void createTransaction(Person person) {
        int price = priceGenerator.nextInt(100); // între 0 și 99
        PaymentStrategy strategy = paymentFactory.getPaymentMethod(person);
        boolean success = person.payBy(strategy, price);
        if (success) {
            person.update();
        }
    }
}
