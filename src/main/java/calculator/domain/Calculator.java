package calculator.domain;

public class Calculator {

    public int calculate(String input) {

        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        if (input.isEmpty()) {
            return 0;
        }

        String delimiter;
        String numbersTest;

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            numbersTest = input.substring(delimiterIndex + 1);
        } else {
            delimiter = "[,:]";
            numbersTest = input;
        }

        String[] numbers = numbersTest.split(delimiter);

        int sum = 0;
        for (String number : numbers) {
            int num;

            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함 되어 있습니다." + number);
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다." + num);
            }
            sum += num;
        }
        return sum;
    }
}
