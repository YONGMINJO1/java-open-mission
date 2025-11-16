package racing.view;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;

public class OutputView {

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String names = collectNames(winners);
        System.out.println("최종 우승자 : " + names);
    }

    private void printCarStatus(Car car) {
        String position = "-".repeat(car.getPosition());
        System.out.println(car.getName() + " : " + position);
    }

    private String collectNames(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        return String.join(", ", names);
    }
}
