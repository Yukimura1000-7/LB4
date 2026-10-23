import java.util.Random;

public class BusinessCar extends Car {
    private static final int MIN_PRICE = 450;
    private static final int MAX_PRICE = 600;

    public BusinessCar() {
        generateCar();
    }

    private void generateCar() {
        Random random = new Random();
        int price = random.nextInt(MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE;
        setPrice(price);
        setName("BusinessCar" + price);
    }

    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}