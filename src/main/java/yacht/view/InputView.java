package yacht.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {

    public static void throwDice() {
        System.out.println();
        System.out.println("주사위를 굴리려면 Enter를 눌러주세요.");
        Console.readLine();
    }

    public static int readCategoryNumber() {
        System.out.println();
        System.out.print("선택할 카테고리 번호를 입력하세요 (게임 종료: 0 ): ");
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

    public static List<Integer> readDiceSelection() {
        System.out.println();
        System.out.print("다시 굴릴 주사위를 선택하세요 (예: 1,3,5 또는 취소: 0): ");
        String input = Console.readLine();
        validateNotEmpty(input);

        if (input.trim().equals("0")) {
            return new ArrayList<>();
        }
        return parseDiceSelection(input);
    }

    private static List<Integer> parseDiceSelection(String input) {
        String[] parts = input.split(",");
        List<Integer> selection = new ArrayList<>();

        for (String part : parts) {
            String trimmed = part.trim();
            validateNumberFormat(trimmed);
            int number = Integer.parseInt(trimmed);
            validateDiceNumber(number);
            selection.add(number);
        }
        validateNoDuplicates(selection);
        return selection;
    }

    private static void validateDiceNumber(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException(
                    "[ERROR] 주사위 번호는 1부터 5 사이여야 합니다."
            );
        }
    }

    private static void validateNoDuplicates(List<Integer> selection) {
        Set<Integer> uniqueNumbers = new HashSet<>(selection);
        if (uniqueNumbers.size() != selection.size()) {
            throw new IllegalArgumentException(
                    "[ERROR] 중복된 주사위 번호가 있습니다."
            );
        }
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
