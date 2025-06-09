package Original;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
