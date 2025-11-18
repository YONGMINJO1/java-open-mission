package yacht.view;

import java.util.List;

public class OutputView {

    public static void printGameStart() {
        System.out.println("게임을 시작합니다.");
    }

    public static void printDices(List<Integer> values) {
        System.out.println();
        System.out.println("주사위를 굴립니다.");

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < values.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append((i + 1) + "번: " + values.get(i));
        }
        result.append("]");
        System.out.println(result.toString());
    }
}
