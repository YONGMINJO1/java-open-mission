package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DiceTest {

    @Test
    void 주사위는_값을_가진다() {
        //given
        int value = 3;

        //when
        Dice dice = new Dice(value);

        //then
        assertThat(dice.getValue()).isEqualTo(3);
    }

    @Test
    void 주사위값은_1부터_6사이여야_한다() {
        //given
        int invalidValueLow = 0;

        //when & then
        assertThatThrownBy(() -> new Dice(invalidValueLow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 6");
    }

    @Test
    void 주사위값이_6보다_크면_예외가_발생한다() {
        //given
        int invalidValueHigh = 7;

        //when & then
        assertThatThrownBy(() -> new Dice(invalidValueHigh))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1부터 6");
    }
}
