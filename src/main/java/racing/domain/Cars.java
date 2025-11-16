package racing.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return findCarsByPosition(maxPosition);
    }

    private int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    private List<Car> findCarsByPosition(int position) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == position) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
