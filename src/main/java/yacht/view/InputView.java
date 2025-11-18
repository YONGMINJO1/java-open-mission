package yacht.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static void throwDice() {
        System.out.println();
        System.out.println("주사위를 굴리려면 Enter를 눌러주세요.");
        Console.readLine();
    }

    public static int readCategoryNumber() {
        System.out.println();
        System.out.print("선택할 카테고리 번호를 입력하세요: ");
        String input = Console.readLine();
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    private static void validateNumberFormat(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }

        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
