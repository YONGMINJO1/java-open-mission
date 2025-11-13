package calculator.domain;

public class Calculator {

    public int calculate(String input) {
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
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}
