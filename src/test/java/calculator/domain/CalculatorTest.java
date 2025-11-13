package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 빈_문자열을_입력하면_0을_반환() {
        //given
        Calculator calculator = new Calculator();
        String input = "";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(0);
    }
}
