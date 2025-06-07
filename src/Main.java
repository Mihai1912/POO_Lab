// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Main.java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Random rand = new Random(20);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int taskNum = scanner.nextInt();




        switch(taskNum) {
            case 1:
                // TODO: uncomment for Task1
                 Car mercedes = new Car(20000, Car.CarType.MERCEDES, 2019);
                 Car fiat = new Car(7000, Car.CarType.FIAT, 2020);
                 Car skoda = new Car(12000, Car.CarType.SKODA, 2022);
                 Dealership dealership = new Dealership();
                break;
            case 2:
                // TODO: uncomment for Task2
                Car[] cars = {
                        new Car(20000, Car.CarType.MERCEDES, 2010),
                        new Car(35000, Car.CarType.MERCEDES, 2015),
                        new Car(3500, Car.CarType.FIAT, 2008),
                        new Car(7000, Car.CarType.FIAT, 2010),
                        new Car(12000, Car.CarType.SKODA, 2015),
                        new Car(25000, Car.CarType.SKODA, 2021)
                };

                dealership = new Dealership();

                for (Car car : cars) {
                    int finalPrice = dealership.getFinalPrice(car);
                }
                break;
            case 3:
                // TODO: uncomment for Task3
                Car clientCar = new Car(20000, Car.CarType.MERCEDES, 2019);

                dealership = new Dealership();

                // Clasă anonimă ce oferă un discount de 5%
                Offer clientOffer = new Offer() {
                    @Override
                    public int getDiscount(Car car) {
                        return (int)(car.getPrice() * 0.05);
                    }
                };

                dealership.negotiate(clientCar, clientOffer);
                break;
            case 4:
                ArrayList<Car> cars1 = new ArrayList<>();

                cars1.add(new Car(20000, Car.CarType.SKODA, 2019));
                cars1.add(new Car(30000, Car.CarType.MERCEDES, 2019));
                cars1.add(new Car(50000, Car.CarType.MERCEDES, 2021));
                cars1.add(new Car(10000, Car.CarType.FIAT, 2018));

                cars1.forEach(System.out::println);

                // Eliminare cu lambda: removeIf
                cars1.removeIf(car -> car.getPrice() > 25000);

                cars1.forEach(System.out::println);
                break;
        }
    }
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Car.java

class Car {
    private int price;
    private CarType carType;
    private int year;

    enum CarType {
        MERCEDES, FIAT, SKODA
    }

    public Car(int price, CarType carType, int year) {
        this.price = price;
        this.carType = carType;
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{price=" + price + ", carType=" + carType + ", year=" + year + "}";
    }
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Offer.java

interface Offer {
    int getDiscount(Car car);
}


// C:/Users/mihai/Desktop/licenta/POO_Lab/src/Original/Dealership.java

class Dealership {

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