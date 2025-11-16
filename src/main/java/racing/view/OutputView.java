package racing.view;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;

public class OutputView {
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String POSITION_MARKER = "-";
    private static final String STATUS_SEPARATOR = " : ";
    private static final String NAME_SEPARATOR = ", ";

    public void printResultHeader() {
        System.out.println();
        System.out.println(RESULT_HEADER);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String names = collectNames(winners);
        System.out.println(WINNER_PREFIX + names);
    }

    private void printCarStatus(Car car) {
        String position = POSITION_MARKER.repeat(car.getPosition());
        System.out.println(car.getName() + STATUS_SEPARATOR + position);
    }

    private String collectNames(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName());
        }
        return String.join(NAME_SEPARATOR, names);
    }
}
