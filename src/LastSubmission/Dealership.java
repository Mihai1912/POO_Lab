package LastSubmission;
public class Dealership {

    private static final Random random = new Random(20);

    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int discount = 0;
            switch (car.getCarType()) {
                case MERCEDES:
                    discount = (int)(car.getPrice() * 0.05);
                    break;
                case FIAT:
                    discount = (int)(car.getPrice() * 0.10);
                    break;
                case SKODA:
                    discount = (int)(car.getPrice() * 0.15);
                    break;
            }
            System.out.println("Applying Brand discount: " + discount + " euros");
            return discount;
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int currentYear = 2022;
            int age = currentYear - car.getYear();
            int discount = 0;
            switch (car.getCarType()) {
                case MERCEDES:
                    discount = age * 300;
                    break;
                case FIAT:
                    discount = age * 100;
                    break;
                case SKODA:
                    discount = age * 150;
                    break;
            }
            System.out.println("Applying Dealer discount: " + discount + " euros");
            return discount;
        }
    }

    private class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            int discount = random.nextInt(1000);
            System.out.println("Applying Special discount: " + discount + " euros");
            return discount;
        }
    }

    public int getFinalPrice(Car car) {
        Offer brandOffer = new BrandOffer();
        Offer dealerOffer = new DealerOffer();
        Offer specialOffer = new SpecialOffer();

        int totalDiscount = brandOffer.getDiscount(car)
                + dealerOffer.getDiscount(car)
                + specialOffer.getDiscount(car);

        return car.getPrice() - totalDiscount;
    }

    public void negotiate(Car car, Offer offer) {
        int discount = offer.getDiscount(car);
        System.out.println("Applying Client discount: " + discount + " euros");
        int finalPrice = car.getPrice() - discount;
    }
}