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

    public static boolean readRerollChoice() {
        System.out.println();
        System.out.print("다시 굴리시겠습니까? (Y/N): ");
        String input = Console.readLine();
        validateNotEmpty(input);
        validateRerollFormat(input);
        return isYes(input);
    }

    private static void validateNumberFormat(String input) {
        validateNotEmpty(input);
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }

    private static void validateRerollFormat(String input) {
        String upperInput = input.toUpperCase();
        if (!upperInput.equals("Y") && !upperInput.equals("N")) {
            throw new IllegalArgumentException("[ERROR] Y 또는 N을 입력해주세요.");
        }
    }

    private static boolean isYes(String input) {
        return input.toUpperCase().equals("Y");
    }
}
