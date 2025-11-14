package calculator.domain;

public class Calculator {


    // 상수
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;
    private static final int CUSTOM_DELIMITER_SEPARATOR_LENGTH = 2;

    public int calculate(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter;
        String numbersTest;

        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SEPARATOR);

            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
            }
            delimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, delimiterIndex);
            numbersTest = input.substring(delimiterIndex + CUSTOM_DELIMITER_SEPARATOR_LENGTH);
        } else {
            delimiter = DEFAULT_DELIMITER;
            numbersTest = input;
        }

        String[] numbers = numbersTest.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            int num;

            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함 되어 있습니다: " + number);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            sum += num;
        }
        return sum;
    }
}
