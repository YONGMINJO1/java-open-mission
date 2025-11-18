package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;

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
}
