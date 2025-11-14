package calculator;

import calculator.controller.CalculatorController;

public class CalculatorApplication {
    public static void main(String[] args) {
        try {
            CalculatorController controller = new CalculatorController();
            controller.run();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
