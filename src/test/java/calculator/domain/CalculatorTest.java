package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 숫자_하나를_입력하면_그대로_반환() {
        //given
        Calculator calculator = new Calculator();
        String input = "5";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표로_구분된_두_숫자를_더하기() {
        //give
        Calculator calculator = new Calculator();
        String input = "1,2";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표로_구분된_여러_숫자를_더하기() {
        //give
        Calculator calculator = new Calculator();
        String input = "1,2,3";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표와_콜론을_함께_사용() {
        //give
        Calculator calculator = new Calculator();
        String input = "1,2:3";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자를_사용() {
        //given
        Calculator calculator = new Calculator();
        String input = "//;\n1;2;3";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수를_입력하면_예외가_발생() {
        //given
        Calculator calculator = new Calculator();
        String input = "-1,2,3";

        //when & then
        assertThatThrownBy(() -> calculator.calculate(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중간에_음수를_입력하면_예외가_발생() {
        //given
        Calculator calculator = new Calculator();
        String input = "1,-2,3";

        //when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_값을_입력하면_예외가_빌생() {
        // given
        Calculator calculator = new Calculator();
        String input = "1,a,3";

        // when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백을_입력하면_예외발생() {
        //given
        Calculator calculator = new Calculator();
        String input = "1, ,3";

        //when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_값이_포함되면_예외가_발생() {
        //given
        Calculator calculator = new Calculator();
        String input = "1,,3";

        //when & then
        assertThatThrownBy(() -> calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
