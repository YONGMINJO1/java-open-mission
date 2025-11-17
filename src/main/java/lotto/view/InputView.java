package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final int LOTTO_PRICE = 1000;

    public int readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int amount = parseNumber(Console.readLine());
        validatePurchaseAmount(amount);
        return amount;
    }

    public List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        return parseNumbers(Console.readLine());
    }

    private List<Integer> parseNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(parseNumber(part.trim()));
        }
        return numbers;
    }

    public int readBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        return parseNumber(Console.readLine());
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
