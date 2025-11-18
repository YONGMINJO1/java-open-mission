package yacht.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class DicesTest {

    @Test
    void 주사위_5개를_생성한다() {
        //given
        List<Dice> diceList = List.of(
                new Dice(1),
                new Dice(2),
                new Dice(3),
                new Dice(4),
                new Dice(5));

        //when
        Dices dices = new Dices(diceList);

        //then
        assertThat(dices.getValues()).hasSize(5);
    }
}
