package calculator.domain;

public class Calculator {

    public int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",");

        if (numbers.length == 1) {
            return Integer.parseInt(numbers[0]);
        }

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}
