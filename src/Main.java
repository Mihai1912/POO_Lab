// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Main.java

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    // DO NOT MODIFY
    private static void test(Person... people) {
        Shop shop = new Shop();
        Random random = new Random(2023);
        shop.addCustomers(List.of(people));

        for (int i = 0; i < 20; i++) {
            int idx = random.nextInt(4);
            shop.createTransaction(shop.getCustomers().get(idx));
        }
    }

    public static void main(String[] args) {
//        TODO - uncomment when done for testing
        Person p1 = new Person("RORNCB221", "523123222", "Gheorghe", "Iliescu", 1234, 287);
        Person p2 = new Person("RORNCB222", "523123223", "Ion", "Popescu", 823, 150);
        Person p3 = new Person("RORNCB223", "523123224", "Giani", "Orlando", 99, 480);
        Person p4 = new Person("RORNCB224", "523123225", "Florin", "Andone", 606, 500);
        test(p1, p2, p3, p4);
    }
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Shop.java






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


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Person.java






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


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/CardPayment.java






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


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/PaymentType.java






enum PaymentType { CARD, IBAN, VOUCHER }


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/VoucherPayment.java






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


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/BalanceObserver.java






interface BalanceObserver {
    void update();
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/PaymentStrategy.java






interface PaymentStrategy {
    void pay(Integer amount);
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/BankAccountPayment.java






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


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/RandomPaymentFactory.java






class RandomPaymentFactory {
    private enum PaymentType { CARD, IBAN, VOUCHER }
    private static final Random random = new Random(1234565);

    public PaymentStrategy getPaymentMethod(Person person) {
        switch (PaymentType.values()[random.nextInt(3)]) {
            case CARD:
                return new CardPayment(person);
            case IBAN:
                return new BankAccountPayment(person);
            case VOUCHER:
                return new VoucherPayment(person);
            default:
                return new CardPayment(person);
        }
    }
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/TransactionPublisher.java






interface TransactionPublisher {
    void createTransaction(Person person);
}
