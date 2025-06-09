package Original;

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
