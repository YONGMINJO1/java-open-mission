package racing.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACE_COUNT_MESSAGE =
            "시도할 횟수는 몇 회인가요?";
    private static final String INVALID_RACE_COUNT_MESSAGE =
            "시도 횟수는 숫자여야 합니다.";


    public List<String> readCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        return parseNames(input);
    }

    public int readRaceCount() {
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        String input = Console.readLine();
        return parseRaceCount(input);
    }

    private List<String> parseNames(String input) {
        String[] names = input.split(",");
        List<String> result = new ArrayList<>();
        for (String name : names) {
            result.add(name.trim());
        }
        return result;
    }

    private int parseRaceCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_RACE_COUNT_MESSAGE);
        }
    }
}
