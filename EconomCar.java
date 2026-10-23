import java.util.Random;

public class EconomCar extends Car {
    private static final int MIN_PRICE = 150;
    private static final int MAX_PRICE = 300;

    public EconomCar() {
        generateCar();
    }

    private void generateCar() {
        Random random = new Random();
        int price = random.nextInt(MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE;
        setPrice(price);
        setName("EconomCar" + price);
    }

    @Override
    public int calculate(int hours) {
        return getPrice() * hours;
    }
}