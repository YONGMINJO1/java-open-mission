package calculator.domain;

public class Calculator {


    // 상수
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SEPARATOR = "\\n";
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int CUSTOM_DELIMITER_PREFIX_LENGTH = 2;
    private static final int CUSTOM_DELIMITER_SEPARATOR_LENGTH = 2;

    public int calculate(String input) {
        validateNotNull(input);

        if (input.isEmpty()) {
            return 0;
        }

        ParseResult parseResult = parseInput(input);
        return sum(parseResult.getNumbersText(), parseResult.getDelimiter());
    }

    private void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
    }

    private ParseResult parseInput(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return parseCustomDelimiter(input);
        }
        return new ParseResult(DEFAULT_DELIMITER, input);
    }

    private ParseResult parseCustomDelimiter(String input) {
        int delimiterIndex = input.indexOf(CUSTOM_DELIMITER_SEPARATOR);

        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못되었습니다.");
        }

        String delimiter = input.substring(CUSTOM_DELIMITER_PREFIX_LENGTH, delimiterIndex);
        String numbersText = input.substring(delimiterIndex + CUSTOM_DELIMITER_SEPARATOR_LENGTH);

        return new ParseResult(delimiter, numbersText);
    }

    private int sum(String numbersText, String delimiter) {
        String[] numbers = numbersText.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            sum += parseAndValidate(number);
        }
        return sum;
    }

    private int parseAndValidate(String number) {
        int num = parseNumber(number);
        validatePositive(num);
        return num;
    }

    private int parseNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함 되어 있습니다: " + number);
        }
    }

    private void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
    }

    private static class ParseResult {
        private final String delimiter;
        private final String numbersText;

        public ParseResult(String delimiter, String numbersText) {
            this.delimiter = delimiter;
            this.numbersText = numbersText;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getNumbersText() {
            return numbersText;
        }
    }

}
