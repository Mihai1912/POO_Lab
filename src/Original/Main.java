package Original;
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
