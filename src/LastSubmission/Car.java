package LastSubmission;
public class Car {
    private int price;
    private CarType carType;
    private int year;

    public enum CarType {
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
