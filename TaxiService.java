import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiService {
    private static final int CARS_COUNT = 16;
    private static final int WORK_HOURS = 8;
    private static final int WORK_DAYS = 5;

    private final List<Car> cars = new ArrayList<>();
    private final Random random = new Random();

    public TaxiService() {
        for (int i = 0; i < CARS_COUNT; i++) {
            if (i % 2 == 0) {
                cars.add(new BusinessCar());
            } else {
                cars.add(new EconomCar());
            }
        }
    }

    public void calculateWeek() {
        int weekIncome = 0;

        for (int day = 1; day <= WORK_DAYS; day++) {
            System.out.println("День " + day);

            int dayIncome = 0;
            Car minIncomeCar = null;
            int minIncome = Integer.MAX_VALUE;

            for (Car car : cars) {
                int hours = random.nextInt(WORK_HOURS + 1);
                int income = car.calculate(hours);

                dayIncome += income;

                System.out.printf("  %s: %d ч -> %d руб.%n",
                        car.getName(), hours, income);

                if (income < minIncome) {
                    minIncome = income;
                    minIncomeCar = car;
                }
            }

            weekIncome += dayIncome;
            System.out.println("  Доход за день: " + dayIncome + " руб.");

            if (minIncomeCar != null && !cars.isEmpty()) {
                cars.remove(minIncomeCar);
                System.out.println("  Уволен таксист: " + minIncomeCar.getName()
                        + " (доход за день: " + minIncome + " руб.)");
            }

            System.out.println("  Осталось машин: " + cars.size());
            System.out.println();
        }

        System.out.println("Доход таксопарка за рабочую неделю: "
                + weekIncome + " руб.");
    }
}